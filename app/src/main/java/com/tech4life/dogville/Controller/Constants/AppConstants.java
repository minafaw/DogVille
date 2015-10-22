package com.tech4life.dogville.Controller.Constants;

/**
 * Created by karma on 27/05/2015.
 */
public class AppConstants {


    public static final String NAME = "name";
    public static final String DETAILS = "details";
    public static final String DETAILS2 = "details2" ;



    //login activity constants
    public static final String USERNAME = "UserName";
    public static final String PASSWORD = "Password";


    // Puppy Order Fields

    public static final String PUPPY_NAME = "puppyName";
    public static final String PUPPY_DESCRIPTION ="puppyDescription" ;
    public static final String PUPPY_IMAGE = "puppyImage" ;
    public static final String PUPPY_GENDER = "puppyGender";
    public static final String PUPPY_USERID = "UserID";
    public static final String PRODUCT_MESSAGE_TAG = "productMessage" ;
    public static final String PRODUCT_ID = "productid" ;
    public static final String TIP_QUESTION_TAG = "question" ;
    public static final String USERID = "userID";

    // Type Models
    public static final String TYPE_NAME = "TypeName";
    public static final String TYPE_ID = "TypeId";
    // Using Local Server Locally
     public static String WEBSERVICE_IP = "http://192.168.1.29:1818/";
     public static String WEBSERVICEURL = "VPMobileService/service.asmx";

    // Common Request
    public static final String DEVICE_IMEI_NUMBER = "DeviceIMEINo";
    public static final String CULTURE = "Culture";

    public static final String CHANNELTYPE = "ChannelType";

    // Common Response
    public static final String IS_SUCCESS = "IsSuccess";
    public static final String RESULT_MESSAGE = "ResultMessage";
    public static final String RESULT_MESSAGE_TYPE = "ResultMessageType";
    public static final String RESPONSE_REF_NO = "ResponseRefNo";
    public static final String CRM_REF_NO = "CRMRefNo";

    // Login Request

    public static final String LOGIN = "Login";
    public static final String LOGIN_REQUEST_OBJECT = "WSFirstLoginRequest";
    public static final String LOGIN_RESULT_OBJECT = "LoginResult";

    // Login Response
    public static final String USER_ID = "userid";
    public static final String USER_MOBILE = "UserMobile";
    public static final String HELP_TEXT = "HelpText";
    public static final String ANOTHER_HELP_TEXT = "AnotherHelpText";
    public static final String CIFNUMBER ="CifNo";

    //Registeration Request
    public static final String REGISTRATION = "Registeration";
    public static final String REGISTRATION_REQUEST_OBJECT = "RegisterationRequest";
    public static final String REGISTRATION_RESULT_OBJECT = "RegisterationResult";

    //Param
    public static final String REGISTRATION_FIRST_NAME = "FirstName";
    public static final String REGISTRATION_LAST_NAME = "LastName";
    public static final String REGISTRATION_GENDER = "Gender";
    public static final String REGISTRATION_PASSWORD = "Password";
    public static final String REGISTRATION_PHONE = "Phone";
    public static final String REGISTRATION_EMAIL = "Email";


    public static final String ALERT = "Alert";
    public static final String EMPTY_MESSAGE = "Please check empty fields ";

    // url constants
    public static final String BASE_URL = "http://dogville.somee.com/UserService.svc/";
    public static final String LOGIN_URL = "login";
    public static final String SINGUP_URL = "register";

    public static final String SECTION = "Section";
    public static final String MEAL_URL = "http://openexchangerates.org/meals.json";
    public static final String USERS_URL = "http://dogville.somee.com/UserService.svc/users";
    public static final String ERROR_LOADING = " Connection Error";
    public static final String PRODUCTS_JSON = "{\"Products\":[{\"ID\":1,\"Name\":\"dog name\",\"Kind\":\"dog\",\"Description1\":\"Age: 6 monthes\",\"Description2\":\"gender: male\",\"Description3\":\"Desc3\",\"Description4\":\"Desc4\",\"ImageURL\":\"http://tech4lifeegypt.com/Dogville/pic1.png\",\"Price\":145,\"MostView\":\"1\"},{\"ID\":2,\"Name\":\"food name\",\"Kind\":\"food\",\"Description1\":\"food desc1\",\"Description2\":\"food desc2\",\"Description3\":\"food desc3\",\"Description4\":\"food desc4\",\"ImageURL\":\"http://tech4lifeegypt.com/Dogville/pic2.png\",\"Price\":140,\"IsRecommeded\":\"1\"},{\"ID\":3,\"Name\":\"dog name\",\"Kind\":\"dog\",\"Description1\":\"Desc2\",\"Description2\":\"Desc3\",\"Description3\":\"Desc4\",\"Description4\":\"Desc5\",\"ImageURL\":\"http://tech4lifeegypt.com/Dogville/pic1.png\",\"Price\":135,\"IsRecommeded\":\"0\"},{\"ID\":4,\"Name\":\"food name\",\"Kind\":\"food\",\"Description1\":\"food desc2\",\"Description2\":\"food desc3\",\"Description3\":\"food desc4\",\"Description4\":\"food desc5\",\"ImageURL\":\"http://tech4lifeegypt.com/Dogville/pic2.png\",\"Price\":130,\"IsRecommeded\":\"1\"},{\"ID\":5,\"Name\":\"dog name\",\"Kind\":\"dog\",\"Description1\":\"Desc3\",\"Description2\":\"Desc4\",\"Description3\":\"Desc5\",\"Description4\":\"Desc6\",\"ImageURL\":\"http://tech4lifeegypt.com/Dogville/pic1.png\",\"Price\":125,\"IsRecommeded\":\"0\"},{\"ID\":6,\"Name\":\"food name\",\"Kind\":\"food\",\"Description1\":\"food desc3\",\"Description2\":\"food desc4\",\"Description3\":\"food desc5\",\"Description4\":\"food desc6\",\"ImageURL\":\"http://tech4lifeegypt.com/Dogville/pic2.png\",\"Price\":120,\"IsRecommeded\":\"1\"},{\"ID\":7,\"Name\":\"dog name\",\"Kind\":\"dog\",\"Description1\":\"Desc4\",\"Description2\":\"Desc5\",\"Description3\":\"Desc6\",\"Description4\":\"Desc7\",\"ImageURL\":\"http://tech4lifeegypt.com/Dogville/pic1.png\",\"Price\":115,\"IsRecommeded\":\"0\"},{\"ID\":8,\"Name\":\"food name\",\"Kind\":\"food\",\"Description1\":\"food desc4\",\"Description2\":\"food desc5\",\"Description3\":\"food desc6\",\"Description4\":\"food desc7\",\"ImageURL\":\"http://tech4lifeegypt.com/Dogville/pic2.png\",\"Price\":110,\"IsRecommeded\":\"1\"},{\"ID\":9,\"Name\":\"dog name\",\"Kind\":\"dog\",\"Description1\":\"Desc5\",\"Description2\":\"Desc6\",\"Description3\":\"Desc7\",\"Description4\":\"Desc8\",\"ImageURL\":\"http://tech4lifeegypt.com/Dogville/pic1.png\",\"Price\":115,\"IsRecommeded\":\"0\"},{\"ID\":10,\"Name\":\"food name\",\"Kind\":\"food\",\"Description1\":\"food desc5\",\"Description2\":\"food desc6\",\"Description3\":\"food desc7\",\"Description4\":\"food desc8\",\"ImageURL\":\"http://tech4lifeegypt.com/Dogville/pic2.png\",\"Price\":120,\"IsRecommeded\":\"0\"},{\"ID\":11,\"Name\":\"dog name\",\"Kind\":\"dog\",\"Description1\":\"Desc6\",\"Description2\":\"Desc7\",\"Description3\":\"Desc8\",\"Description4\":\"Desc9\",\"ImageURL\":\"http://tech4lifeegypt.com/Dogville/pic1.png\",\"Price\":125,\"IsRecommeded\":\"1\"},{\"ID\":12,\"Name\":\"food name\",\"Kind\":\"food\",\"Description1\":\"food desc6\",\"Description2\":\"food desc7\",\"Description3\":\"food desc8\",\"Description4\":\"food desc9\",\"ImageURL\":\"http://tech4lifeegypt.com/Dogville/pic2.png\",\"Price\":130,\"IsRecommeded\":\"1\"},{\"ID\":13,\"Name\":\"dog name\",\"Kind\":\"dog\",\"Description1\":\"Desc7\",\"Description2\":\"Desc8\",\"Description3\":\"Desc9\",\"Description4\":\"Desc10\",\"ImageURL\":\"http://tech4lifeegypt.com/Dogville/pic1.png\",\"Price\":135,\"IsRecommeded\":\"0\"},{\"ID\":14,\"Name\":\"food name\",\"Kind\":\"food\",\"Description1\":\"food desc7\",\"Description2\":\"food desc8\",\"Description3\":\"food desc9\",\"Description4\":\"food desc10\",\"ImageURL\":\"http://tech4lifeegypt.com/Dogville/pic2.png\",\"Price\":140,\"IsRecommeded\":\"0\"},{\"ID\":15,\"Name\":\"dog name\",\"Kind\":\"dog\",\"Description1\":\"Desc8\",\"Description2\":\"Desc9\",\"Description3\":\"Desc10\",\"Description4\":\"Desc11\",\"ImageURL\":\"http://tech4lifeegypt.com/Dogville/pic1.png\",\"Price\":145,\"IsRecommeded\":\"1\"},{\"ID\":16,\"Name\":\"food name\",\"Kind\":\"food\",\"Description1\":\"food desc8\",\"Description2\":\"food desc9\",\"Description3\":\"food desc10\",\"Description4\":\"food desc11\",\"ImageURL\":\"http://tech4lifeegypt.com/Dogville/pic2.png\",\"Price\":140,\"IsRecommeded\":\"1\"},{\"ID\":17,\"Name\":\"dog name\",\"Kind\":\"dog\",\"Description1\":\"Desc9\",\"Description2\":\"Desc10\",\"Description3\":\"Desc11\",\"Description4\":\"Desc12\",\"ImageURL\":\"http://tech4lifeegypt.com/Dogville/pic1.png\",\"Price\":135,\"IsRecommeded\":\"0\"},{\"ID\":18,\"Name\":\"food name\",\"Kind\":\"food\",\"Description1\":\"food desc9\",\"Description2\":\"food desc10\",\"Description3\":\"food desc11\",\"Description4\":\"food desc12\",\"ImageURL\":\"http://tech4lifeegypt.com/Dogville/pic2.png\",\"Price\":130,\"IsRecommeded\":\"0\"},{\"ID\":19,\"Name\":\"dog name\",\"Kind\":\"dog\",\"Description1\":\"Desc10\",\"Description2\":\"Desc11\",\"Description3\":\"Desc12\",\"Description4\":\"Desc13\",\"ImageURL\":\"http://tech4lifeegypt.com/Dogville/pic1.png\",\"Price\":125,\"IsRecommeded\":\"1\"},{\"ID\":20,\"Name\":\"food name\",\"Kind\":\"food\",\"Description1\":\"food desc10\",\"Description2\":\"food desc11\",\"Description3\":\"food desc12\",\"Description4\":\"food desc13\",\"ImageURL\":\"http://tech4lifeegypt.com/Dogville/pic2.png\",\"Price\":120,\"IsRecommeded\":\"0\"}]}";

    public static final String Dogs_URL = "http://dogville.somee.com/UserService.svc/allPuppies";
    public static final String PRODUCTS_URL = "http://dogville.somee.com/UserService.svc/Products";
    public static final String MESSAGE = "Message" ;

    public static final String HOME_ACCESSORY = "http://dogville.somee.com/UserService.svc/homeAccessory";
    public static final String HOME_PUPPIES = "http://dogville.somee.com/UserService.svc/homePuppies";
    public static final String HOME_FOOD =  "http://dogville.somee.com/UserService.svc/homeFood";
    public static final String PUPPY_ORDER = "http://dogville.somee.com/UserService.svc/puppyOrder";
    public static final String PRODUCT_MESSAGE = "http://dogville.somee.com/UserService.svc/productMessage";
    public static final String PRODUCT_TYPES =  "http://dogville.somee.com/UserService.svc/productTypes";
    public static final String PRODUCTS_BY_TYPE = "http://dogville.somee.com/UserService.svc/productByType";
    public static final String TIP_QUESTION =  "http://dogville.somee.com/UserService.svc/tipQuestion";
    public static final String ORDER =  "http://dogville.somee.com/UserService.svc/order";
    // constants for ui view layers
    public static String PRODUCTS = "Products";
    public static String ACCESSORIES = "Accessories";
    public static String FOODS = "Foods";
    public static String DOGS = "Dogs";


    public static String EMPTY_FIELD = "Please find empty field";
    public static String INVALID_EMAIL = "Please Enter valid E-mail";


}
