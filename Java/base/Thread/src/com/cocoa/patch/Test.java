package com.cocoa.patch;

import java.io.File;

import static com.apple.eio.FileManager.getResource;
import static com.sun.org.apache.xalan.internal.xsltc.compiler.util.Type.Text;

/**
 * Created by sj on 16/9/10.
 */
public class Test {


    public static void main(String[] args) {

        String dir = Test.class.getResource("").getPath();
        Test test = new Test();

        System.out.println(test.getLastPatchCode("1.1.1", dir));


//        String str = "12312.123";
//
//        System.out.println(str.contains("."));


    }

    public static final int DEFAULT_PATCH_CODE = 0;
    public static final String PATCH_END = ".apatch";
    public static final String FILE_DOT = ".";
    public static final String FILE_HYPHEN = "-";


    public int getLastPatchCode(String appVersion, String patchDir) {
        File patchFile = new File(patchDir);
        if (patchFile == null || !patchFile.exists()) { // 还未创建缓存目录
            return DEFAULT_PATCH_CODE;
        }
        File[] patchFiles = patchFile.listFiles();
        if (patchFiles == null || patchFiles.length == 0) {// 暂时没有补丁
            return DEFAULT_PATCH_CODE;
        }
        int code = DEFAULT_PATCH_CODE;

        for (File file : patchFiles) {
            String fileName = file.getName();   //  1.1.1-1.apatch
            if (!fileName.endsWith(PATCH_END)) {
                continue;
            }
            if (!fileName.startsWith(appVersion)) {
                continue;
            }
            if (!fileName.contains(FILE_HYPHEN) || !fileName.contains(FILE_DOT)) {
                continue;
            }

            String[] hyphenArray = fileName.split(FILE_HYPHEN);  //  {"1.1.1" , "1.apatch"}

            if (hyphenArray == null || hyphenArray.length != 2) {
                continue;
            }

            String codeEndStr = hyphenArray[1];      // "1.apatch"

            if (codeEndStr.length() == 0) {
                continue;
            }

            try {

                String codeStr = codeEndStr.substring(0, codeEndStr.lastIndexOf(FILE_DOT));// "1"

                if (codeStr == null || codeStr.length() == 0) {
                    continue;
                }

                int tempCode = Integer.parseInt(codeStr);
                if (code < tempCode) {
                    code = tempCode;
                }
            } catch (Exception e) {
            }

        }
        return code;
    }


}
