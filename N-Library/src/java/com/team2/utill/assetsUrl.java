package com.team2.utill;

import javax.servlet.http.HttpServletRequest;
/**
 *
 * @author Ashani
 */
public class assetsUrl {
    
             public static String giveUrl(HttpServletRequest request, String path)
             {
                 
                    
                    String fileUrl = request.getScheme() + "://" + request.getServerName()+ ":" + request.getServerPort() + request.getServletContext() .getContextPath() + "/";
//                    String fileUrl = request.getScheme() + "://" + request.getServerName() + "/" + request.getServletContext().getContextPath() + "/";
                    String url = fileUrl + path;
                    
                 return url;
             }
             
}
