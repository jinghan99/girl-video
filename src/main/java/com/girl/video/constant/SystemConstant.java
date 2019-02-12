package com.girl.video.constant;


import com.girl.video.utils.PropertiesUtils;

import java.awt.*;
import java.io.File;

/**
 * 系统级静态变量
 *
 * @author ZhouChenglin
 * @email yczclcn@163.com
 * @url www.chenlintech.com
 * @date 2017年8月8日 下午1:35:38
 */
public class SystemConstant {


	
	/**
	 * 超级管理员ID
	 */
	public static final long SUPER_ADMIN = 1;

    /**
     * 验证码 背景色
     */
	public static final Color CODE_IMG_BG= new Color(13, 88, 144);
	
	/**
	 * 数据标识
	 */
	public static final String DATA_ROWS = "rows";
	
	/**
	 * 未授权错误代码
	 */
	public static final int UNAUTHORIZATION_CODE = 401;

    /**
     * 接口 token失效
     */
	public static final int TOKEN_FAIL = 402;

	/**
	 * 数据权限sql
	 */
	public static final String DATA_PERMISSION = "data_permission_sql";

//网易云信 app server key

    //创建用户
    public static final String NIM_CreateUrl = PropertiesUtils.getInstance("application").get("NIM_CreateUrl");



    //修改信息
    public static final String NIM_UpdateUrl = PropertiesUtils.getInstance("application").get("NIM_UpdateUrl");

    //添加好友
    public static final String NIM_FriendAdd = PropertiesUtils.getInstance("application").get("NIM_FriendAdd");

    //更新并获取新的token
    public static final String NIM_RefreshTokenUrl = PropertiesUtils.getInstance("application").get("NIM_RefreshTokenUrl");
    //应用app key
    public static final String NIM_AppKey = PropertiesUtils.getInstance("application").get("NIM_AppKey");

    public static final String NIM_AppSecret = PropertiesUtils.getInstance("application").get("NIM_AppSecret");

    public static final String TTS_FILE_URL = PropertiesUtils.getInstance("application").get("fileUrl") + File.separator + "tts";
	/**
	 *
	 *@Params: redis 前缀规范
	 *@Date: 2018/6/15 9:37
	 *@Author: jinghan
	 */ 
	public enum RedisType{

        /**
         * 工位前缀
         *
         */
        CUBICLE("CUBICLE_"),


        /**
         * 字典
         */
        PBM("P_BM_"),

        /**
         * token前缀
         */
        Token("Token_"),

        /**
         * user key 存 token值
         */
        UserToT("UserToT_"),
        /**
         * Token key 存 user值
         */
        TokenToU("TokenToU_");
        private String value;

        RedisType(String value) {
            this.value = value;
        }

        public String getValue() {
            return this.value;
        }
    }


    /**
     *
     *@Params: 字典值
     *@Date: 2018/6/20 15:02
     *@Author: jinghan
     */ 
    public enum macroVlaue{


        /**
         * 否
         */
        No("0401"),

        /**
         * 是
         */
        Yes("0402"),
        /**
         * 盒子版本
         */
        boxVersion("0201"),

        /**
         * 盒子状态
         */
        boxStatus("0202"),

        /**
         * web端账号类型 （社区账号，派出所账号）
         */
        webType("0210"),



        /**
         * 映射码类型 == 用户类型
         */
        authType("0201"),

        userType("0204"),

        /**
         * 通话状态
         */
        callStatus("0207"),

        /**
         * 通话状态 接通中
         */
        CallConnectIng("020701"),
        /**
         * 通话状态 未接通
         */
        CallConnectN("020702"),
        /**
         * 通话状态 已接通
         */
        CallConnectY("020703"),

//        大众盒子版本
        boxPublic("020101"),

//        企业盒子版本
        boxCompany("020102"),

        /**
         * 律师用户类型
         */
        LawyerUserType("020403"),

        /**
         * 企业用户
         */
        companyUserType("020402"),

        /**
         * 大众用户
         */
        publicUserType("020401"),

        /**
         * apk类型
         */
        apkType("0102"),

        /**
         * 评价标签
         */
        evaluateTags("0208"),

        /**
         * 映射码 对端属性
         */
        authAttribute("0209"),

        /**
         * 映射码 对端属性 盒子端
         */
        authAttributeBox("020901"),

        /**
         * 映射码 对端属性 web端
         */
        authAttributeWeb("020902"),

        /**
         * 通话类型
         */
        callRecordType("0211"),

        callRecordZixu("021101"),

        /**
         * 工位类型
         */
        cubicleType("0212"),


        /**
         * 工位
         */
        cubicle("021201"),

        /**
         * 组位
         */
        cublicTypeItem("021202"),


        /**
         * web端账号 派出所
         */
        webPolice("021001"),
        ;




        private String value;

        macroVlaue(String value) {
            this.value = value;
        }

        public String getValue() {
            return this.value;
        }
    }

	/**
	 * 日志类型
	 */
	public enum LogType {

		/**
		 * 登录登出日志
		 */
		LOGIN(1),

		/**
		 * 访问日志
		 */
		ACCESS(2),

		/**
		 * 操作日志
		 */
		OPERATION(3),

		/**
		 * 异常日志
		 */
		ERROR(4),

		/**
		 * 授权日志
		 */
		AUTHORIZATION(5);

		private int value;

		LogType(int value) {
			this.value = value;
		}

		public int getValue() {
			return this.value;
		}

	}
	
	/**
	 * 菜单类型
	 *
	 * @author ZhouChenglin
	 * @email: yczclcn@163.com
	 * @url: www.chenlintech.com
	 * @date 2017年8月8日 下午1:36:27
	 */
    public enum MenuType {
        /**
         * 目录
         */
    	CATALOG(0),
        /**
         * 菜单
         */
        MENU(1),
        /**
         * 按钮
         */
        BUTTON(2);

        private int value;

        MenuType(int value) {
            this.value = value;
        }

        public int getValue() {
            return value;
        }
    }
    
    /**
     * 定时任务状态
     *
     * @author ZhouChenglin
     * @email: yczclcn@163.com
     * @url: www.chenlintech.com
     * @date 2017年8月8日 下午1:36:17
     */
    public enum ScheduleStatus {
        /**
         * 正常
         */
    	NORMAL(1),
        /**
         * 暂停
         */
    	PAUSE(0);

        private int value;

        ScheduleStatus(int value) {
            this.value = value;
        }
        
        public int getValue() {
            return value;
        }
    }
    
    /**
     * 通用字典
     *
     * @author ZhouChenglin
     * @email yczclcn@163.com
     * @url www.chenlintech.com
     * @date 2017年8月15日 下午7:29:02
     */
    public enum MacroType {
    	
    	/**
    	 * 类型
    	 */
    	TYPE(0),
    	
    	/**
    	 * 参数
    	 */
    	PARAM(1);
    	
    	private int value;
    	
    	MacroType(int value) {
            this.value = value;
        }
        
        public int getValue() {
            return value;
        }
    	
    }
    
    /**
     * 通用变量，表示可用、禁用、显示、隐藏
     *
     * @author ZhouChenglin
     * @email yczclcn@163.com
     * @url www.chenlintech.com
     * @date 2017年8月15日 下午7:31:49
     */
    public enum StatusType {
    	
    	/**
    	 * 禁用，隐藏
    	 */
    	DISABLE(0),
    	
    	/**
    	 * 可用，显示
    	 */
    	ENABLE(1),
    	
    	/**
    	 * 显示
    	 */
    	SHOW(1),
    	
    	/**
    	 * 隐藏
    	 */
    	HIDDEN(0);
    	
    	private int value;
    	
    	StatusType(int value) {
            this.value = value;
        }
        
        public int getValue() {
            return value;
        }
    	
    }

}
