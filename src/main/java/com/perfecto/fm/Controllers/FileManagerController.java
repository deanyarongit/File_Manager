package com.perfecto.fm.Controllers;

import com.perfecto.fm.Services.FileManagerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping(value = "fileManager/v1/rest/fileManager")
public class FileManagerController {

    @Autowired
    FileManagerService test;

    @RequestMapping(method = RequestMethod.GET)
    public String ptree() {
        return test.printroot();
    }
}
