package util;

public class Constants {

	public static final String File_Path = "/Users/joyshen/eclipse-workspace/MlsAutomation/"; // 放excel的路徑
	public static final String File_Name = "excelData.xlsx"; // excel檔名

	// login page
	public static final String START_BTN_ID = "textView";
	public static final String INPUT_USERNAME_ID = "usernameInput";
	public static final String INPUT_PASSWORD_ID = "passwdInput";
	public static final String CLICK_LOGIN_BTN_ID = "loginBtn";
	public static final String CLICK_PASSWORD_CONFIRM_BTN_ID = "密碼"; // 登出後的密碼欄位設為空，text顯示為default值為"密碼"

	// invalid login
	public static final String INPUT_INVALID_USERNAME = "joyyy@staging.com.tw";
	public static final String INPUT_INVALID_PASSWORD = "11111111";
	public static final String INVALID_LOGIN_TOAST_XPATH = "//*[contains(@text, 'User with this email/username does not exist.')]";
	public static final String INVALID_LOGIN_ERROR_MESSAGE = "User with this email/username does not exist.";

	// main page
	public static final String LIVETOUR_TAB_NAME = "tabLivetour";
	public static final String LIST_BY_CLASS = "android.widget.TextView";
	public static final String NAVI_MORE_BTN_ID = "navi_more";
	public static final String CREATE_NEW_LIVETOUR_BTN_ID = "textView12";
	public static final String EDIT_NEW_LIVETOURNAME_BTN_ID = "editText5";
	public static final String INPUT_NEW_LIVETOURNAME = "auto-testing";
	public static final String CONFIRM_CREATE_NEW_LIVETOUR_BTN_ID = "namingChange";
	public static final String NEW_LIVETOUR_NAME_ID = "projectName";
	public static final String EDIT_BTN_ID = "edit";
	public static final String CREATE_NEWLIVETOUR_TOAST_XPATH = "//*[contains(@text, '成功')]";

	// import photos from gallery
	public static final String INPUT_NEW_LIVETOURNAME_FOR_IMPORT_PHOTOS = "importPhotoFromGallery";
	public static final String ADD_PANO_BTN_ID = "add";
	public static final String GALLERY_ICON_ID = "goGallery";
	public static final String SELECT_PHOTO_CHECK_BTN_ID = "emptyCheckView";
	public static final String ACTION_SAVE_BTN_ID = "action_save";
	public static final String LIVETOUR_TITLE_ID = "title";
	public static final String BUILDING_DETAIL_PAGE_EDIT_BTN_ID="edit";
//	public static final String PANO_NAME_XPATH = "//android.widget.TextView[contains(@text,'Others')]";
	public static final String CHECK_IMPORT_PHOTO_NUMBER_ID = "rootView";

	// delete livetour
	public static final String INPUT_NEW_LIVETOURNAME_FOR_DELETE_TEST = "delete-livetour-test";
	public static final String SELECT_LIVETOUR_TO_BE_DELETED_ID = "com.iStaging.vrcameraphone:id/projectName";
	public static final String SELECT_LIVETOUR_TO_BE_DELETED_TEXT = "delete-livetour-test";
	public static final String DELETE_LIVETOUR_BTN_ID = "delete";
	public static final String CONFIRM_DELETE_LIVETOUR_BTN_BY_NAME = "刪除";
	public static final String DELETE_LIVETOUR_TOAST_XPATH = "//*[contains(@text, '成功')]";

	// profile page
	public static final String LOGOUT_BTN_ID = "logout";
	public static final String CONFIRM_LOGOUT_BTN = "android:id/button1";

}
