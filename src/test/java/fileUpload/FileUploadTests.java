package fileUpload;

import base.BaseTests;
import org.testng.annotations.Test;

import java.io.File;

import static org.testng.Assert.assertEquals;

public class FileUploadTests extends BaseTests {

    @Test
    public void testFileUpload(){
        var uploadPage = homePage.clickFileUpload();
        /*
        * I needed to user this File to be able to use a relative path for my file.
        * You can use an absolute file path if you wish to
        * */
        File file = new File("src/main/resources/testFileUpload.txt");
        String absolutePath = file.getAbsolutePath();

        uploadPage.uploadFile(absolutePath);
        assertEquals(uploadPage.getUploadedTitle(), "File Uploaded!", "File uploaded not completed");
    }
}
