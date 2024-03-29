package constants;

public final class FrameworkConstants {

    private FrameworkConstants(){}
    private static final String RESOURCESPATH = System.getProperty("user.dir")+"/src/test/resources";
    private static final String CONFIGFILEPATH = RESOURCESPATH+"/config.properties";
    private static final String JSONCONFIGFILEPATH = RESOURCESPATH+"/config.json";

    public static String getConfigFilePath() {
        return CONFIGFILEPATH;
    }

    public static String getJsonConfigFilePath(){
        return JSONCONFIGFILEPATH;
    }
}
