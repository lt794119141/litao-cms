package com.litao.cms.controller;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.apache.kafka.clients.producer.KafkaProducer;
import org.elasticsearch.action.search.SearchAction;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.elasticsearch.core.ElasticsearchTemplate;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.litao.cms.util.HLUtils;

import scala.util.Random;

import com.litao.cms.dao.ArticleRepository;
import com.bawei.utils.StringUtil;
import com.github.pagehelper.PageInfo;
import com.litao.cms.common.CmsConstant;
import com.litao.cms.common.JsonResult;
import com.litao.cms.dao.ArticleDao;
import com.litao.cms.pojo.Article;
import com.litao.cms.pojo.Category;
import com.litao.cms.pojo.Channel;
import com.litao.cms.pojo.Collect;
import com.litao.cms.pojo.Slide;
import com.litao.cms.pojo.User;
import com.litao.cms.service.ArticleService;
import com.litao.cms.service.CollectService;
import com.litao.cms.service.SlideService;

@Controller
@RequestMapping("/article/")
public class ArticleController {
	@Autowired
	private ArticleService articleService;
	private Logger logger = LoggerFactory.getLogger(getClass());
	
	@Autowired
	private SlideService slideService;
	
	@Autowired
	private ArticleRepository articleReposititory;
	@Autowired
	private ElasticsearchTemplate elasticsearchTemplate;
	
	@Autowired
	private CollectService collectService;
	
	
	/**文章搜索 */
	@RequestMapping("search")
	public String Search(@RequestParam(defaultValue="1")Integer pageNum,String key,Model model) {
		
		/** 频道 */
		List<Channel> channelList = articleService.getChannelList();
		model.addAttribute("channelList", channelList);
		/** 轮播图 */
		List<Slide> slideList = slideService.getAll();
		model.addAttribute("slideList", slideList);
		/** 最新文章 **/
		List<Article> newArticleList = articleService.getNewList(6);
		model.addAttribute("newArticleList", newArticleList);
		/** 热点文章 **/
		PageInfo<?> pageInfo = HLUtils.findByHighLight(elasticsearchTemplate, Article.class, pageNum, 6,new String[] {"title"}, "hot", key);
		model.addAttribute("pageInfo", pageInfo);
		return  "index";
	}
	
	/**
	 * @Title: add   
	 * @Description: 发布文章   
	 * @param: @return      
	 * @return: String      
	 * @throws
	 */
	@RequestMapping(value="add",method=RequestMethod.GET)
	public String add(Integer id,Model model) {
		logger.info("articleId:{}",id);
		if(id!=null) {
			Article article = articleService.getById(id);
			logger.info(article.toString());
			model.addAttribute("article", article);
			List<Category> cateList = articleService.getCateListByChannelId(article.getChannelId());
			model.addAttribute("cateList", cateList);
		}
		List<Channel> channelList = articleService.getChannelList();
		model.addAttribute("channelList", channelList);
		return "article/add";
	}
	
	@RequestMapping(value="add",method=RequestMethod.POST)
	@ResponseBody
	public JsonResult add(Article article,Model model,HttpSession session) {
		System.out.println(article);
		User userInfo = (User)session.getAttribute(CmsConstant.UserSessionKey);
		if(userInfo==null) {
			return JsonResult.fail(CmsConstant.unLoginErrorCode, "未登录");
		}
		article.setUserId(userInfo.getId());
		boolean result = articleService.save(article);
		return JsonResult.sucess(result);
	}
	/**
	 * @Title: getCateList   
	 * @Description: 根据频道Id查询分类列表   
	 * @param: @param channelId
	 * @param: @param model
	 * @param: @param session
	 * @param: @return      
	 * @return: JsonResult      
	 * @throws
	 */
	@RequestMapping(value="getCateList",method=RequestMethod.GET)
	@ResponseBody
	public JsonResult getCateList(Integer channelId,Model model,HttpSession session) {
		return JsonResult.sucess(articleService.getCateListByChannelId(channelId));
	}
	/**
	 * @Title: delByIds   
	 * @Description: 批量删除   
	 * @param: @param ids
	 * @param: @return      
	 * @return: JsonResult      
	 * @throws
	 */
	@RequestMapping("delByIds")
	public @ResponseBody JsonResult delByIds(String ids) {
		if(ids==null) {
			return JsonResult.fail(10001, "请选择删除的文章");
		}
		//已审核判断
		boolean isCheck = articleService.isAllCheck(ids);
		if(!isCheck) {
			return JsonResult.fail(10001, "请选择未审核的文章删除");
		}
		//删除
		boolean result = articleService.delByIds(ids);
		if(result) {
			return JsonResult.sucess();
		}
		return JsonResult.fail(500, "未知错误");
	}
	
	@RequestMapping("collect")
	public String  collecting(String url,HttpSession session,Model model) {
		
		String replace = url.replace("*","?");
		System.out.println(replace);
		String[] split = replace.split("id=");
		if(StringUtil.isHttpUrl(replace)) {
			User userInfo = (User)session.getAttribute(CmsConstant.UserSessionKey);
			if(userInfo.getId()==null) {
				return "redirect:/user/login";
			}
			int in=collectService.getCollect(split[1]);
			if(in>0) {
				model.addAttribute("succ", "您已收藏过，请勿重复收藏");
				return "redirect:/article/"+split[1]+".html";
			}
			
			Article article = articleService.getById(Integer.parseInt(split[1]));
			Date date = new Date();
			SimpleDateFormat format = new SimpleDateFormat();
			String format2 = format.format(date);
			System.out.println(format2);
			String st1="20"+format2;
			String st2=st1.replace("上午", "");
			String st3=st2.replace("下午", "");
			String st4=st3.replace("中午", "");
			Random random = new Random();
			int i = random.nextInt(60);
			String created=st4+":"+i;
			System.out.println(created);
			
			Collect collect = new Collect();
			collect.setCreated(created);
			collect.setText(article.getTitle());
			collect.setUrl(replace);
			collect.setUser_id(userInfo.getId());
			boolean b=collectService.add(collect);
			
			model.addAttribute("succ", "收藏成功");
		}else {
			System.out.println("url地址错误");
		}
		
		
		return "redirect:/article/"+split[1]+".html";
	}
	
}