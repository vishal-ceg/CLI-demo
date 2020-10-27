/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.cli.demo;

import java.io.File;
import java.nio.file.Path;
import java.util.concurrent.Callable;
import picocli.CommandLine;
import picocli.CommandLine.Command;
import picocli.CommandLine.Option;

/**
 *
 * @author Vishal
 */
@Command(name = "fileCli", version = "checksum 4.0", description = "Performs file manipulation operations")
public class App implements Callable<String> {
    
     @Option(names = { "-v", "--version" }, description = "version") 
    boolean  version = false;
    
    @Option(names = "-cf", description = "Creates a new file with given name")
    private String name;
 
    public static void main(String... args) throws Exception {
        int exitCode = new CommandLine(new App()).execute(args);
        System.exit(exitCode);
    }
    
    public String call() throws Exception {
 
        if (name != null) {
            File file = new File(name);
            if (!file.exists()) {
                file.createNewFile();
            }
        }
        if(version) {
            System.out.println("Version: 1.0");
        }
        return "success";
    }
    
    
}
