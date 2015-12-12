package com.lockMgr.controller;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import sun.misc.BASE64Decoder;

import com.lockMgr.core.Utils;
import com.lockMgr.pojo.Collect;
import com.lockMgr.pojo.News;
import com.lockMgr.pojo.Newslocks;
import com.lockMgr.pojo.Newstype;
import com.lockMgr.pojo.Operator;
import com.lockMgr.pojo.Review;
import com.lockMgr.pojo.User;
import com.lockMgr.pojo.Viewhistory;
import com.lockMgr.service.ICollectService;
import com.lockMgr.service.INewsService;
import com.lockMgr.service.INewstypeService;
import com.lockMgr.service.IReviewService;
import com.lockMgr.service.IUserService;
import com.lockMgr.service.IViewhistoryService;
import com.lockMgr.util.KeyEnum;
import com.lockMgr.util.StatusEnum;

/**
 * 论坛action
 */
public class NewsAction extends BaseAction {
	private static final long serialVersionUID = -5890524099413013607L;
	
	//private int reviewPageSize = 10;  //电脑端每页显示评论数(仅限本类中方法使用,不需要get(),set()方法)
	
	private int page = 1;
	private int limit;
	private int rows;
	private String newsId;
	private String userId;
	private int type;
	private String title;
	private String content;
	private String ImgData;
	private String collectId;
	private String newstypeName; //动态版块名称
	private String newstypeComment; //动态版块介绍
	private String newstypeId;
	private int newstypeStatus;
	private String sort;
	private String id;
	private String[] idlist;
	private int totalPage;
	private List<Newslocks> newsLocksList;
	private List<Review> reviewList;
	private String newsType;  //电脑端网页类型
	private String editorValue;
	

	private INewsService newsService;
	private IUserService userService;
	private IViewhistoryService viewhistoryService;
	private IReviewService reviewService;
	private INewstypeService newstypeService;
	private ICollectService collectService;

	private Viewhistory viewhistory;
	private Review review;
	private News news;
	private Newstype newstype;
	private Collect collect;
	
	/**
	 * 网页版电脑端
	 * 问题：新帖,阅读历史,板块(板块中有n种分类),又由于一个action对应一个jsp页面,造成blog.jsp一个页面就
	 * 		要对应一个帖子分类(blog.jsp页码部分代码固定,在页码代码中判断帖子类型不可取),这样及其不好扩展.
	 * 解决：给每种帖子类型带个参数tupe,用来区别帖子类型,在该action中再来判断是哪种类型帖子.
	 * 目前帖子类型：
	 * 		新帖(默认)：				newsType = a
	 * 		阅读历史：				newsType = b
	 * 		板块(最新活动资讯)：		newsType = c0
	 * 		板块(汽车解码技术交流)：	newsType = c1
	 * 		板块(民用开锁技术交流)：	newsType = c2
	 * 		板块(汽车遥控匹配方法)：	newsType = c3
	 * 		板块(芯片钥匙匹配方法)：	newsType = c4
	 * 		板块(汽车电脑维修资料)：	newsType = c5
	 * 		板块(二手设备出售)：		newsType = c6
	 */
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public String getNewsByAllTypeOfComputer() {
		Map all = new HashMap();
		if(newsType == null || newsType.trim().equals("a")) {
			all = newsService.findNewsByTime(page, limit);
		} else if(newsType.trim().equals("b")) {
			newsService.findNewsByHistory(page, limit, userId);
		} else if(newsType.trim().startsWith("c", 0)) {
			if(newsType.trim().endsWith("0"))
				all = newsService.findNewsByType(page, limit, 0);
			else if(newsType.trim().endsWith("1"))
				all = newsService.findNewsByType(page, limit, 1);
			else if(newsType.trim().endsWith("2"))
				all = newsService.findNewsByType(page, limit, 2);
			else if(newsType.trim().endsWith("3"))
				all = newsService.findNewsByType(page, limit, 3);
			else if(newsType.trim().endsWith("4"))
				all = newsService.findNewsByType(page, limit, 4);
			else if(newsType.trim().endsWith("5"))
				all = newsService.findNewsByType(page, limit, 5);
			else if(newsType.trim().endsWith("6"))
				all = newsService.findNewsByType(page, limit, 6);
		}
		newsLocksList = (List<Newslocks>) all.get("newsLocksList");
		Integer totalPageOfInteger = (Integer) all.get("totalPage");
		totalPage = totalPageOfInteger.intValue();
		return "success";
	}
	
	/**
	 * 板块
	 * @throws IOException
	 */
	@SuppressWarnings({ "rawtypes", "unchecked" })
	public String getNewsByType() throws IOException {
		Map json = new HashMap();
		Map all = newsService.findNewsByType(page, limit, type);
		List<Newslocks> list = (List<Newslocks>) all.get("newsLocksList");
		if (list.size() == 0) {
			json.put("success", false);
			json.put("msg", "暂时无人发表论坛贴!");
		} else {
			json.put("success", true);
			json.put("forumlist", list);
		}
		Utils.senchaview(json);
		return null;
	}

	/**
	 * 新帖
	 * @throws IOException
	 */
	@SuppressWarnings({ "rawtypes", "unchecked" })
	public String getNewsByTime() throws IOException {
		Map json = new HashMap();
		Map all = newsService.findNewsByTime(page, limit);
		List<Newslocks> list = (List<Newslocks>) all.get("newsLocksList");
		if (list.size() == 0) {
			json.put("success", false);
			json.put("msg", "暂时无人发表论坛贴!");
		} else {
			json.put("success", true);
			json.put("forumlist", list);
		}
		Utils.senchaview(json);
		return null;
	}
	
	/**
	 * 新帖(电脑端)
	 */
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public String getNewsByTimeOfComputer() {
		Map all = newsService.findNewsByTime(page, limit);
		newsLocksList = (List<Newslocks>) all.get("newsLocksList");
		Integer totalPageOfInteger = (Integer) all.get("totalPage");
		totalPage = totalPageOfInteger.intValue();
		return "success";
	}

	/**
	 * 阅读历史
	 * @throws IOException
	 */
	@SuppressWarnings({ "rawtypes", "unchecked" })
	public void getNewsByHistory() throws IOException {
		Map json = new HashMap();
		if(userId != null && userId.length() > 0) {
			Map all = newsService.findNewsByHistory(page, limit, userId);
			List<Newslocks> list = (List<Newslocks>) all.get("newsLocksList");
			if (list.size() == 0) {
				json.put("success", false);
				json.put("msg", "您暂时还没有浏览记录!");
			} else {
				json.put("success", true);
				json.put("forumlist", list);
			}
		} else {
			json.put("success", true);
			json.put("msg", "您还不是注册用户,暂无浏览记录!");
		}
		Utils.senchaview(json);

	}

	/**
	 * 获取论坛版块列表
	 * 
	 * @throws IOException
	 */
	@SuppressWarnings({ "rawtypes", "unchecked" })
	public String getNewsTypeList() throws IOException {
		Map json = new HashMap();
//		List<Newstype> list = this.newstypeService.listAll();
		List<Newstype> list = this.newstypeService.findAllNewstype(page, limit);
		if (list.size() == 0) {
			json.put("success", false);
			json.put("msg", "目前论坛还没任何版块呢！！");
		} else {
			json.put("forumlist", list);
			json.put("success", true);
		}
		Utils.senchaview(json);
		return null;
	}
	
	/**
	 * 新增论坛版块动态列表记录
	 * @throws IOException 
	 */
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public void addNewsType() throws IOException {
		Map json = new HashMap();
		try {
			if (newstypeName == null || newstypeName.length() == 0) {
				json.put("success", false);
				json.put("msg", "请输出您要添加的版块名称！！");
			} else {
				int type = newstypeService.checkingType();
				newstype = new Newstype();
				newstype.setName(newstypeName);
				newstype.setComment(newstypeComment);
				newstype.setType(type);
				newstype.setStatus(1);
				newstypeService.save(newstype);
				json.put("success", true);
				json.put("msg", "版块添加成功！！");
			}
		} catch (Exception e) {
			json.put("success", false);
			json.put("msg", "添加错误，请重试！！");
		}
		Utils.senchaview(json);
	}
	
	/**
	 * 停用该论坛版块
	 * @throws IOException 
	 */
	@SuppressWarnings({ "rawtypes", "unchecked" })
	public void cancelNewsType() throws IOException {
		Map json = new HashMap();
		if(newstypeId==null || newstypeId.length()==0) {
			json.put("success", false);
			json.put("msg", "停用失败，请重试！！");
		} else {
			newstype = newstypeService.findById(newstypeId);
			newstype.setStatus(0);
			newstypeService.saveOrUpdate(newstype);
			json.put("success", true);
			json.put("msg", "停用成功！！");
		}
		Utils.senchaview(json);
	}
	
	/**
	 * 查看已停用论坛版块列表
	 * @throws IOException 
	 */
	@SuppressWarnings({ "rawtypes", "unchecked" })
	public void getNewsTypeDisabled() throws IOException {
		Map json = new HashMap();
		List<Newstype> list = newstypeService.findNewstypeDisabled(page, limit);
		if(list.size()==0) {
			json.put("success", true);
			json.put("msg", "您还没停用任何版块！！");
		} else {
			json.put("success", true);
			json.put("forumlist", list);
		}
		Utils.senchaview(json);
	}
	
	/**
	 * 重新启用之前停用的论坛版块
	 * @throws IOException 
	 */
	@SuppressWarnings({ "rawtypes", "unchecked" })
	public void enableNewsType() throws IOException {
		Map json = new HashMap();
		if(newstypeId==null || newstypeId.length()==0) {
			json.put("success", false);
			json.put("msg", "启用失败，请重试！！");
		} else {
			newstype = newstypeService.findById(newstypeId);
			newstype.setStatus(1);
			newstypeService.saveOrUpdate(newstype);
			json.put("success", true);
			json.put("msg", "启用成功！！");
		}
		Utils.senchaview(json);
	}

	/**
	 * 我的发布(根据用户id查询该用户曾经发布的论坛帖)
	 * 模板跟版块,新帖,阅读历史一样,只要那5个数据.
	 * @throws IOException 
	 */
	@SuppressWarnings({ "rawtypes", "unchecked" })
	public String getNewsByUser() throws IOException {
		Map json = new HashMap();
		Map all = newsService.findNewsByUser(page, limit, userId);
		List<Newslocks> list = (List<Newslocks>) all.get("newsLocksList");
		if(list.size()==0) {
			json.put("success", false);
			json.put("msg", "您暂时还没成功发布任何论坛帖，可到论坛版块进行发帖！！");
		} else {
			json.put("success", true);
			json.put("forumlist", list);
		}
		Utils.senchaview(json);
		return null;
	}
	
	/**
	 * 发帖
	 * @throws IOException
	 */
	@SuppressWarnings({ "rawtypes", "unchecked", "deprecation" })
	public String saveNews() throws IOException {
		Map json = new HashMap();
		if (userId == null || userId.length() == 0 || title == null
				|| title.length() == 0 || content == null
				|| content.length() == 0) {
			json.put("success", false);
			json.put("msg", "error");
		} else {
			String userName = userService.findById(userId).getAccount();
			news = new News();
			news.setStatus(1);
			news.setUserId(userId);
			news.setUserName(userName);
			news.setViewCount(0);
			news.setReviewCount(0);
			news.setType(type);
			news.setTitle(title);
			news.setContent(content);

			BASE64Decoder decode = new BASE64Decoder();
			if (ImgData != null) {
//				ImgData = ImgData.substring(ImgData.lastIndexOf(",")+1);
				byte[] b = decode.decodeBuffer(ImgData);
				for (int i = 0; i < b.length; i++) {
					if(b[i]<0){
						b[i]+=256;
					}
				}
				String saved =getRequest().getRealPath("/")+"/file/img/";
				System.out.println(saved);
				String sname =Utils.getNewUUID().replaceAll("-", "");
				File f =new File(saved);
				if(!f.exists()){
					f.mkdir();
				}
				saved=saved+sname+".jpg";
				OutputStream out =new FileOutputStream(new File(saved));
				out.write(b);
				out.flush();
				out.close();
				news.setComment(sname+".jpg");
			}
			newsService.save(news);
			json.put("success", true);
			json.put("msg", "您的论坛帖正在进行审核！！");
		}
		Utils.senchaview(json);
		return null;
	}

	/**
	 * 电脑端发帖
	 * @throws IOException 
	 */
	@SuppressWarnings({ "rawtypes", "unchecked" })
	public void saveNewsOfComputer() throws IOException {
		//userId, userName, type, title, content
		Map m = new HashMap();
		User user = (User) getSession().get(KeyEnum.USER);  //得到session中的USER
		if(user != null) {
//			newsService.saveNewsByComputer(user.getId(), title, content, type);
			System.out.println("editorValue:" + editorValue);
			System.out.println("content:"  + content);
			newsService.saveNewsByComputer(user.getId(), title, content, type);
			m.put("success", true);
			m.put("msg", "发表成功!");
		} else {
			m.put("success", false);
			m.put("msg", "请先登录再发表!");
		}
		jsonViewIE(m);
	}
	
	/**
	 * 浏览
	 * @throws IOException
	 */
	@SuppressWarnings({ "rawtypes", "unchecked" })
	public String view() throws IOException {
		Map json = new HashMap();
		if (newsId == null) {
			json.put("success", false);
			json.put("msg", "没有对应论坛");
		} else if (newsId != null && userId == null) {
			// 1.查询该帖内容
			// List<News> newsList = newsService.findNewsById(newsId);
			News news = this.newsService.findById(newsId);
			/*if (news.getContent() != null && news.getContent().length() != 0) {
				news.setContent(replaceComment(news.getContent()));
			}*/ //content内容没有设置图片,帖子图片有且只有一张,而且是放在comment字段上
			//1.替换图片路径
			if(news.getComment() != null && news.getComment().length() != 0)
				news.setComment(Utils.getimagepath() + news.getComment());
			// 2.查询该贴第一页评论
			List<Review> reviewList = reviewService.findReviewByNewsId(1, limit, newsId);
			for (int i = 0; i < reviewList.size(); i++) {
				if (reviewList.get(i).getContent() != null && reviewList.get(i).getContent().length() != 0) {
					reviewList.get(i).setContent(replaceComment(reviewList.get(i).getContent()));
				}
			}
			// 3.news表中viewCount字段加1
			newsService.addViewcount(newsId);
			json.put("success", true);
			json.put("newsArticles", news);
			json.put("reviewListArticles", reviewList);
			// 4.typeName
			news.setTypeName(newstypeService.findNameByType(news.getType()));
		} else if (newsId != null && userId != null) {
			// List<NewsEcho> list = newsService.view(newsId, viewhistory);
			// 1.查询该帖内容
			// List<News> newsList = newsService.findNewsById(newsId);
			News news = this.newsService.findById(newsId);
			/*if (news.getContent() != null && news.getContent().length() != 0) {
				news.setContent(replaceComment(news.getContent()));
			}*/ //content内容没有设置图片,帖子图片有且只有一张,而且是放在comment字段上
			//1.替换图片路径
			if(news.getComment() != null && news.getComment().length() != 0)
				news.setComment(Utils.getimagepath() + news.getComment());
			// 2.查询该贴第一页评论
			List<Review> reviewList = reviewService.findReviewByNewsId(1, 10, newsId);
			for (int i = 0; i < reviewList.size(); i++) {
				if (reviewList.get(i).getContent() != null && reviewList.get(i).getContent().length() != 0) {
					reviewList.get(i).setContent(replaceComment(reviewList.get(i).getContent()));
				}
			}
			// 3.保存一条浏览记录到viewHistory表中
			Viewhistory viewhistory = new Viewhistory();
			viewhistory.setNewsId(newsId);
			viewhistory.setUserId(userId);
			// newsService.saveViewhistory(viewhistory);
			this.viewhistoryService.save(viewhistory);
			// 4.news表中viewCount字段加1
			newsService.addViewcount(newsId);
			// 5.typeName
			news.setTypeName(newstypeService.findNameByType(news.getType()));
			json.put("success", true);
			json.put("newsArticles", news);
			json.put("reviewListArticles", reviewList);
		}
		Utils.senchaview(json);
		return null;
	}
	/**
	 * 电脑版浏览论坛贴功能
	 * @return
	 */
	public String viewOfComputer() {
		news = newsService.findById(id);
		if(news != null) {
			//1.替换图片路径
			if(news.getComment() != null && news.getComment().length() != 0)
				news.setComment(Utils.getimagepath() + news.getComment());
			// 2.查询该贴第一页评论
			reviewList = reviewService.findReviewByNewsId(1, 4, id);
			// 3.news表中viewCount字段加1
			newsService.addViewcount(id);
			// 4.如果用户登录了(保存条浏览记录到viewhistory表中)
			if(userId != null && userId.length() != 0) {
				Viewhistory vh = new Viewhistory();
				vh.setNewsId(id);
				vh.setUserId(userId);
				viewhistoryService.save(vh);
			}
			// 5.返回总页数(主要是评论总页数), +1就是帖子一页加上评论总页数
			totalPage = reviewService.findReviewTotalPage(id) + 1;
		}
		return "success";
	}
	
	/**
	 * 查看评论(分页,从第二页开始)
	 * @throws IOException 
	 */
	@SuppressWarnings({ "rawtypes", "unchecked" })
	public String getReviewByPage() throws IOException {
		Map json = new HashMap();
		List<Review> reviewList = reviewService.findReviewByNewsId(page, limit, newsId);
		for (int i = 0; i < reviewList.size(); i++) {
			if (reviewList.get(i).getContent() != null && reviewList.get(i).getContent().length() != 0) {
				reviewList.get(i).setContent(replaceComment(reviewList.get(i).getContent()));
			}
		}
		json.put("success", true);
		json.put("reviewListArticles", reviewList);
		Utils.senchaview(json);
		return null;
	}
	/**
	 * 查看评论(分页,从第二页开始)
	 * notes: 页码问题(由于第一页涉及到了帖子内容和部分评论而牵扯到的问题)
	 * 解决：第一页任然显示帖子内容和部分评论(比以后页评论少,本人第一页评论设置为4条,以后每页都10条),
	 * 		第二页正常显示评论(从头开始查询,这样避免了丢失5-10条评论记录问题),
	 * 		传递totalPage 要+1(帖子内容占一页)
	 * 		查询评论的时候page - 1 即可
	 * 
	 */
	public String getReviewOfComputer() {
		reviewList = reviewService.findReviewByNewsId(page-1, limit, id);
		// 返回总页数, +1就是帖子一页加上评论总页数
		totalPage = reviewService.findReviewTotalPage(id) + 1;
		//需要存在个当前news对象,解决在评论页面无法找到帖子id现象(否则就要实时绑定session帖子id)
		news = newsService.findById(id);
		return "success";
	}
	
	/**
	 * 评论
	 * @throws IOException
	 */
	@SuppressWarnings({ "rawtypes", "unchecked", "deprecation" })
	public String review() throws IOException {
		Map json = new HashMap();
		if (newsId == null || userId == null || content == null) {
			json.put("success", false);
			json.put("msg", "评论出错，请重试！！");
		} else {
			// List<Review> list = newsService.review(newsId, r);
			// 1.往评论记录表中添加一条记录
			String userName = userService.findById(userId).getAccount();
			review = new Review();
			review.setNewsId(newsId);
			review.setUserId(userId);
			review.setContent(content);
			review.setUserName(userName);
			
			BASE64Decoder decode = new BASE64Decoder();
			if (ImgData != null) {
				byte[] b = decode.decodeBuffer(ImgData);
				for (int i = 0; i < b.length; i++) {
					if(b[i]<0){
						b[i]+=256;
					}
				}
				String saved = getRequest().getRealPath("/")+"/file/img/";
				String sname = Utils.getNewUUID().replaceAll("-", "");
				File f = new File(saved);
				if(!f.exists()){
					f.mkdir();
				}
				saved = saved+sname+".jpg";
				OutputStream out = new FileOutputStream(new File(saved));
				out.write(b);
				out.flush();
				out.close();
				review.setComment(sname+".jpg");
			}
			
			// newsService.saveReview(review);
			reviewService.save(review);
			// 2.论坛表中评论次数加1
			newsService.addReviewcount(newsId);
			json.put("success", true);
			json.put("msg", "评论正在审核中");
		}
		Utils.senchaview(json);
		return null;
	}
	
	/**
	 * 根据用户id查询该用户收藏帖
	 * @throws IOException 
	 */
	@SuppressWarnings({ "rawtypes", "unchecked" })
	public String getCollectByUser() throws IOException {
		Map json = new HashMap();
		if(userId==null || userId.length()==0) {
			json.put("success", false);
			json.put("msg", "用户id不能为空！！");
		} else {
			List<Collect> collectList = collectService.findCollectByUser(page, limit, userId);
			if(collectList.size() == 0) {
				json.put("success", false);
				json.put("msg", "您暂时还没收藏！！");
			} else {
				/*
				 * 由于收藏表中只有userId,newsId字段,需另外根据newsId查询帖信息(在此只返回5个基本信息,同板块,新帖功能.)
				 * 如需该帖详细信息,可访问view.action功能
				 */
				List<Newslocks> newsList = new ArrayList<Newslocks>();
				for(int i=0; i<collectList.size(); i++) {
					String newsid = collectList.get(i).getNewsId();
					String hql = "from News where id=?";
					//根据newsid查询该贴主用户id
					List<News> oriNewsList = newsService.find(hql, new Object[]{newsid});
					if(oriNewsList.get(0).getUserId() != null && oriNewsList.size() != 0) {
						String userid = oriNewsList.get(0).getUserId();
						List<Newslocks> nlList = collectService.findNewsById(newsid,userid);
						if(nlList != null && nlList.size() != 0) 
							newsList.add(nlList.get(0));
					}
//					String userid = newsService.find(hql, new Object[]{newsid}).get(0).getUserId(); 
//					newsList.add(collectService.findNewsById(newsid,userid).get(0));
				}
				for(int j=0; j<newsList.size(); j++) {
					Newslocks nl = newsList.get(j);
					collectList.get(j).setTitle(nl.getTitle());
					collectList.get(j).setUserName(nl.getUserName());
					collectList.get(j).setImage(nl.getImage());
					collectList.get(j).setViewCount(nl.getViewCount());
					collectList.get(j).setReviewCount(nl.getReviewCount());
				}
				json.put("success", true);
				json.put("collectList", collectList);
//				json.put("newsList", newsList);
			}
		}
		Utils.senchaview(json);
		return null;
	}
	
	/**
	 * 添加收藏
	 * @throws IOException 
	 */
	@SuppressWarnings({ "rawtypes", "unchecked" })
	public String addCollect() throws IOException {
		Map json = new HashMap();
		try {
			if(userId == null || userId.length() == 0 || newsId == null
					|| newsId.length() == 0) {
				json.put("success", false);
				json.put("msg", "用户id和论坛帖id不能为空！！");
			} else {
				if(collectService.checkingCollectByUser(userId, newsId)) {
					json.put("success", false);
					json.put("msg", "您已收藏过该论坛帖！！");
				} else {
					collect = new Collect();
					collect.setUserId(userId);
					collect.setNewsId(newsId);
					collect.setStatus(1); //1表示收藏存在
					collectService.save(collect);
					json.put("success", true);
					json.put("msg", "添加收藏成功！！");
				}
			}
		} catch (Exception e) {
			json.put("success", false);
			json.put("msg", "添加收藏失败，请稍后重试！");
		}
		Utils.senchaview(json);
		return null;
	}
	
	/**
	 * 取消收藏(修改状态为0)
	 * @throws IOException 
	 */
	@SuppressWarnings({ "rawtypes", "unchecked" })
	public void cancelCollect() throws IOException {
		Map json = new HashMap();
		try {
			if (collectId == null || collectId.length() == 0) {
				json.put("success", false);
				json.put("msg", "收藏id为空，取消收藏失败！！");
			} else {
				collect = collectService.findById(collectId);
				collect.setStatus(0);
				collectService.saveOrUpdate(collect);
				json.put("success", true);
				json.put("msg", "取消收藏成功！！");
			}
		} catch (Exception e) {
			json.put("success", false);
			json.put("msg", "取消收藏失败！！");
		}
		Utils.senchaview(json);
	}

	/**
	 * 分页查询帖子类型信息
	 * @throws IOException 
	 */
	@SuppressWarnings({ "rawtypes", "unchecked", "unused" })
	public void getNewsTypeByPage() throws IOException {
		Map session = this.getSession();
		Map json = new HashMap();
		newstypeService.findNewsTypeByPage(json, page, rows, newstypeStatus, sort);
		json.put(KeyEnum.STATUS, StatusEnum.success);
		jsonViewIE(json);
	}
	
	/**
	 * 测试
	 * @return
	 * @throws IOException
	 */
	@SuppressWarnings({ "rawtypes", "unchecked" })
	public String test() throws IOException {
		Map json = new HashMap();
		News news = this.newsService.findById(newsId);
		List<Review> reviewList = reviewService.findReviewByNewsId(page, limit, newsId);
		json.put("success", true);
		json.put("news", news);
		json.put("reviewList", reviewList);
		Utils.senchaview(json);
		return null;
	}

	/**
	 * 查询全部论坛版块类型
	 * @throws IOException 
	 */
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public void getAllNewstype() throws IOException {
		Map json = new HashMap();
		List<Newstype> list = newstypeService.listAll();
		json.put("success", true);
		json.put("newstype", list);
		Utils.senchaview(json);
	}
	
	/**
	 * (删除)停用论坛版块类型
	 * @throws IOException 
	 */
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public void cancelNewstype() throws IOException {
		Map session = getSession();
		Operator oper = (Operator) session.get(KeyEnum.OPERATOR);
		Map json = new HashMap();
		StatusEnum status = StatusEnum.success;
		String reason = null;
		if(! newstypeService.txCancelNewstype(oper, idlist)) {
			status = StatusEnum.failed;
			reason = "删除失败";
		}
		json.put(KeyEnum.STATUS, status);
		json.put(KeyEnum.REASON, reason);
		jsonViewIE(json);
	}
	
	/**
	 * 增加论坛版块类型
	 * @return
	 * @throws IOException 
	 */
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public void addNewstype() throws IOException {
		Map session = getSession();
		Operator oper = (Operator) session.get(KeyEnum.OPERATOR);
		Map jsondata = new HashMap();
		newstypeService.txAddNewstype(oper, newstype);
		jsondata.put(KeyEnum.STATUS, StatusEnum.success);
		jsonViewIE(jsondata);
	}
	
	/**
	 * 修改论坛版块类型
	 * @return
	 */
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public void editNewstype() throws IOException {
		Map session = getSession();
		Operator oper = (Operator) session.get(KeyEnum.OPERATOR);
		Map jsondata = new HashMap();
		StatusEnum status = StatusEnum.success;
		String reason = null;
		if (! newstypeService.txUpdateNewstype(oper, newstype, id)) {
			status = StatusEnum.failed;
			reason = "修改失敗";
		}
		jsondata.put(KeyEnum.STATUS, status);
		jsondata.put(KeyEnum.REASON, reason);
		jsonViewIE(jsondata);
	}
	
	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public INewsService getNewsService() {
		return newsService;
	}

	public void setNewsService(INewsService newsService) {
		this.newsService = newsService;
	}

	public String getNewsId() {
		return newsId;
	}

	public void setNewsId(String newsId) {
		this.newsId = newsId;
	}

	public Viewhistory getViewhistory() {
		return viewhistory;
	}

	public void setViewhistory(Viewhistory viewhistory) {
		this.viewhistory = viewhistory;
	}

	public Review getReview() {
		return review;
	}

	public void setReview(Review review) {
		this.review = review;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public IReviewService getReviewService() {
		return reviewService;
	}

	public void setReviewService(IReviewService reviewService) {
		this.reviewService = reviewService;
	}

	public IViewhistoryService getViewhistoryService() {
		return viewhistoryService;
	}

	public void setViewhistoryService(IViewhistoryService viewhistoryService) {
		this.viewhistoryService = viewhistoryService;
	}

	public News getNews() {
		return news;
	}

	public void setNews(News news) {
		this.news = news;
	}

	public IUserService getUserService() {
		return userService;
	}

	public void setUserService(IUserService userService) {
		this.userService = userService;
	}

	public INewstypeService getNewstypeService() {
		return newstypeService;
	}

	public void setNewstypeService(INewstypeService newstypeService) {
		this.newstypeService = newstypeService;
	}

	public Newstype getNewstype() {
		return newstype;
	}

	public void setNewstype(Newstype newstype) {
		this.newstype = newstype;
	}

	public String getImgData() {
		return ImgData;
	}

	public void setImgData(String imgData) {
		ImgData = imgData;
	}

	public int getType() {
		return type;
	}

	public void setType(int type) {
		this.type = type;
	}

	public ICollectService getCollectService() {
		return collectService;
	}

	public void setCollectService(ICollectService collectService) {
		this.collectService = collectService;
	}

	public Collect getCollect() {
		return collect;
	}

	public void setCollect(Collect collect) {
		this.collect = collect;
	}

	public String getCollectId() {
		return collectId;
	}

	public void setCollectId(String collectId) {
		this.collectId = collectId;
	}

	public int getPage() {
		return page;
	}

	public void setPage(int page) {
		this.page = page;
	}

	public int getLimit() {
		return limit;
	}

	public void setLimit(int limit) {
		this.limit = limit;
	}

	public String getNewstypeName() {
		return newstypeName;
	}

	public void setNewstypeName(String newstypeName) {
		this.newstypeName = newstypeName;
	}

	public String getNewstypeComment() {
		return newstypeComment;
	}

	public void setNewstypeComment(String newstypeComment) {
		this.newstypeComment = newstypeComment;
	}

	public String getNewstypeId() {
		return newstypeId;
	}

	public void setNewstypeId(String newstypeId) {
		this.newstypeId = newstypeId;
	}

	public int getRows() {
		return rows;
	}

	public void setRows(int rows) {
		this.rows = rows;
	}

	public int getNewstypeStatus() {
		return newstypeStatus;
	}

	public void setNewstypeStatus(int newstypeStatus) {
		this.newstypeStatus = newstypeStatus;
	}

	public String getSort() {
		return sort;
	}

	public void setSort(String sort) {
		this.sort = sort;
	}

	public String[] getIdlist() {
		return idlist;
	}

	public void setIdlist(String[] idlist) {
		this.idlist = idlist;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
		idlist = id.replaceAll("'", "").split(",");
		}

	public int getTotalPage() {
		return totalPage;
	}

	public void setTotalPage(int totalPage) {
		this.totalPage = totalPage;
	}

	public List<Newslocks> getNewsLocksList() {
		return newsLocksList;
	}

	public void setNewsLocksList(List<Newslocks> newsLocksList) {
		this.newsLocksList = newsLocksList;
	}

	public List<Review> getReviewList() {
		return reviewList;
	}

	public void setReviewList(List<Review> reviewList) {
		this.reviewList = reviewList;
	}

	public String getNewsType() {
		return newsType;
	}

	public void setNewsType(String newsType) {
		this.newsType = newsType;
	}

	public String getEditorValue() {
		return editorValue;
	}

	public void setEditorValue(String editorValue) {
		this.editorValue = editorValue;
	}
	

}
