package com.perfecto.fm.Controllers;


import com.perfecto.fm.Api.ApiFile;
import com.perfecto.fm.Services.FileManagerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "fileManager/v1/rest/file")
public class FileController {

    @Autowired
    FileManagerService test;


    @RequestMapping(method = RequestMethod.POST)
    public void addfile(@RequestBody ApiFile NFile) {
        test.addFile(NFile.getPdira(), NFile.getName(), NFile.getSize(), NFile.getDate());

    }

    //@RequestMapping(method = RequestMethod.DELETE)
    @RequestMapping( method= RequestMethod.DELETE)
    public void removefile(@RequestBody String FName) {
        test.deleteFile(FName);

    }


}


