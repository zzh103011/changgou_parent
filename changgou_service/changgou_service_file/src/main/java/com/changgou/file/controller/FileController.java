package com.changgou.file.controller;

import com.changgou.file.config.FastDFSClientUtil;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

/**
 * @author zzh
 * @description: TODO
 * @date 2023年02月14日 16:01
 */
@RestController
@RequestMapping("/file")
public class FileController {

    @Autowired
    private FastDFSClientUtil fastDFSClientUtil;

    @Value("${fileServerUrl}")
    private String fileServerUrl ;

    /**
     * 上传图片
     * @param file
     * @return
     */
    @PostMapping("/upload")
    public String uploadFile(MultipartFile file) {
        try {
            if (file == null) {
                throw new RuntimeException("文件不存在");
            }
            //获取文件的完整名称
            String filename = file.getOriginalFilename();
            if (StringUtils.isEmpty(filename)) {
                throw new RuntimeException("文件不存在");
            }
            String url = fastDFSClientUtil.uploadFile(file);
            return fileServerUrl+url;
        } catch (IOException e) {
            e.printStackTrace();
        }
        return "文件上传失败";
    }


    @GetMapping("/del")
    public String delFile(@RequestParam String fileId) {
        try {
            fastDFSClientUtil.delFile(fileId);
            return "删除成功";
        }catch (Exception e){
            e.printStackTrace();
        }
        return "删除失败";
    }

    public static void main(String[] args) {
        String[] arr = {"flower", "flew", "flow"};
        String common = findCommonLetters(arr);
        System.out.println(common); // 输出 "fl"
    }

    public static String findCommonLetters(String[] arr) {
        if (arr == null || arr.length == 0) {
            return "";
        }
        // 将第一个字符串作为基准，逐一比较后面的字符串是否含有相同的字母
        String base = arr[0];
        for (int i = 0; i < base.length(); i++) {
            char c = base.charAt(i);
            for (int j = 1; j < arr.length; j++) {
                if (!arr[j].contains(String.valueOf(c))) {
                    // 如果有任意一个字符串不包含当前字母，则直接结束当前循环，继续比较下一个字母
                    break;
                }
                if (j == arr.length - 1) {
                    // 如果所有字符串都包含当前字母，则将其加入结果字符串
                    return base.substring(0, i+1);
                }
            }
        }
        return "";
    }

}
