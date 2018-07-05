package com.perfecto.fm.Services;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.HashMap;

public class Directory extends Node {
    private Map<String,File> FileList;
    private List<Directory> cildrens;


    public Map<String,File> getFileList() {
        return FileList;
    }
    public List<Directory> getCildrens() {
        return cildrens;
    }

    public Directory(String name, String date, Directory PDir) {
        super(name, date, PDir);
        FileList = new HashMap<String,File>();
        cildrens = new ArrayList<Directory>();
    }

    void AddFile(File newF) {
        FileList.put(newF.getName(),newF);
    }

    void AddDir(Directory newD) {
        cildrens.add(newD);
    }

    public void printTree(int level, StringBuilder view) {
        for (int i = 1; i < level; i++) {
           // if( )
            view.append("\t");
        }
        view.append("dir:" + getName() + "\n");

        for (Map.Entry<String,File> child : FileList.entrySet()) {
            for (int i = 1; i < level; i++) {
                view.append("\t") ;

            }
            view.append("file:" + child.getValue().getName() + "\n");

        }
        for (Directory child : this.getCildrens()) {
            child.printTree(level + 1 ,view);
        }


    }
}
