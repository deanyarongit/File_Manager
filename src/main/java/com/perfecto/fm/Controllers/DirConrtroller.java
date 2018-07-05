package com.perfecto.fm.Controllers;


import com.perfecto.fm.Api.ApiDir;
import com.perfecto.fm.Services.FileManagerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping(value = "fileManager/v1/rest/dir")
public class DirConrtroller {


    @Autowired
    FileManagerService test;

    @RequestMapping(method = RequestMethod.POST)
    public void adddir(@RequestBody ApiDir Ndir) {
        test.addDir(Ndir.getPdira(), Ndir.getName(), Ndir.getDate());
    }

    @RequestMapping(method = RequestMethod.DELETE)
    public void removedir(@RequestBody String DName) {
        test.deleteFile(DName);

    }



}




