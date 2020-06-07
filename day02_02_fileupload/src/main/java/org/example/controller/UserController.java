package org.example.controller;

import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.WebResource;
import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.util.List;
import java.util.UUID;

@Controller
@RequestMapping("/user")
public class UserController {

    /**
     * 方法: 文件上傳
     *
     * @return java.lang.String
     */
    @RequestMapping("/fileupload1")
    public String fileupload1(HttpServletRequest request) throws Exception {
        System.out.println("文件上傳...");

        // 使用 fileupload component 完成文件上傳
        // 上傳的位置
        String path = request.getSession().getServletContext().getRealPath("/uploads/");
        // 判斷該路徑是否存在
        File file = new File(path);
        if (!file.exists()) {
            // 建立該文件夾
            file.mkdirs();
        }

        // 解析 request 物件，取得上傳文件
        DiskFileItemFactory factory = new DiskFileItemFactory();
        ServletFileUpload upload = new ServletFileUpload(factory);
        // 解析 request
        List<FileItem> items = upload.parseRequest(request);
        // 遍歷
        for (FileItem item : items) {
            // 判斷當前 item 物件是否是上傳文件
            if (item.isFormField()) {
                // 表示普通表單 item

            } else {
                // 表示上傳文件 item
                // 取得上傳文件的名稱
                String filename = item.getName();
                // 把文件的名稱設置唯一值，UUID
                String uuid = UUID.randomUUID().toString().replace("-", "");
                filename = uuid + "_" + filename;
                // 完成文件上傳
                item.write(new File(path, filename));
                // 刪除臨時文件
                item.delete();
            }
        }

        return "success";
    }

    /**
     * 方法: SpringMVC 文件上傳
     *
     * @return java.lang.String
     */
    @RequestMapping("/fileupload2")
    public String fileupload2(HttpServletRequest request, MultipartFile upload) throws Exception {
        System.out.println("SpringMVC 文件上傳...");

        // 使用 fileupload component 完成文件上傳
        // 上傳的位置
        String path = request.getSession().getServletContext().getRealPath("/uploads/");
        // 判斷該路徑是否存在
        File file = new File(path);
        if (!file.exists()) {
            // 建立該文件夾
            file.mkdirs();
        }


        // 表示上傳文件 item
        // 取得上傳文件的名稱
        String filename = upload.getOriginalFilename();
        // 把文件的名稱設置唯一值，UUID
        String uuid = UUID.randomUUID().toString().replace("-", "");
        filename = uuid + "_" + filename;
        // 完成文件上傳
        upload.transferTo(new File(path, filename));


        return "success";
    }

    /**
     * 方法: 跨 Server 文件上傳
     *
     * @return java.lang.String
     */
    @RequestMapping("/fileupload3")
    public String fileupload3(MultipartFile upload) throws Exception {
        System.out.println("跨 Server 文件上傳...");

        // 定義上傳文件 Server 地址
        String path = "http://localhost:9090/fileupload/uploads/";

        // 表示上傳文件 item
        // 取得上傳文件的名稱
        String filename = upload.getOriginalFilename();
        // 把文件的名稱設置唯一值，UUID
        String uuid = UUID.randomUUID().toString().replace("-", "");
        filename = uuid + "_" + filename;

        // 建立客戶端物件
        Client client = Client.create();

        // 和 圖片Server 進行連接
        WebResource webResource = client.resource(path + filename);

        // 上傳文件
        webResource.put(upload.getBytes());

        return "success";
    }
}
