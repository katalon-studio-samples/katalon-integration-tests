package internal

import com.kms.katalon.core.configuration.RunConfiguration
import com.kms.katalon.core.testobject.ObjectRepository as ObjectRepository
import com.kms.katalon.core.testdata.TestDataFactory as TestDataFactory
import com.kms.katalon.core.testcase.TestCaseFactory as TestCaseFactory
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase

/**
 * This class is generated automatically by Katalon Studio and should not be modified or deleted.
 */
public class GlobalVariable {
     
    /**
     * <p></p>
     */
    public static Object api_key
     
    /**
     * <p></p>
     */
    public static Object server_url
     
    /**
     * <p></p>
     */
    public static Object app_name
     
    /**
     * <p></p>
     */
    public static Object web_url
     
    /**
     * <p></p>
     */
    public static Object batch_info
     
    /**
     * <p></p>
     */
    public static Object change_test
     

    static {
        def allVariables = [:]        
        allVariables.put('default', [:])
        allVariables.put('applitools', allVariables['default'] + ['api_key' : 'DdKwFvb104ZVrU4eSXB1kBHpuuoNwV110aiL8100NLAMKGji8110', 'server_url' : 'https://eyesapi.applitools.com', 'app_name' : 'Hello World App', 'web_url' : 'https://applitools.com/helloworld2', 'batch_info' : 'Research Batch', 'change_test' : true])
        
        String profileName = RunConfiguration.getExecutionProfile()
        
        def selectedVariables = allVariables[profileName]
        api_key = selectedVariables['api_key']
        server_url = selectedVariables['server_url']
        app_name = selectedVariables['app_name']
        web_url = selectedVariables['web_url']
        batch_info = selectedVariables['batch_info']
        change_test = selectedVariables['change_test']
        
    }
}
