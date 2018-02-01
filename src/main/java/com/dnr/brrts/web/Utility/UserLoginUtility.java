package com.dnr.brrts.web.Utility;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;
import sun.misc.BASE64Decoder;

@Component
public class UserLoginUtility {

    private static final Logger logger = LoggerFactory.getLogger(UserLoginUtility.class);


    public String getLoggedinUserName() {
        logger.info("..............Inside getLoggedInUserName method..................");

        Object principal = SecurityContextHolder.getContext()
                .getAuthentication().getPrincipal();

        if (principal instanceof UserDetails) {
            UserDetails user =  ((UserDetails) principal);
            logger.info("User" + user.getUsername());
            return user.getUsername();
        }else {
            return  null;
        }
    }

    private static final String BASIC  = "Basic ";
    private static final String CN_KEY = "cn=";
    private static final String COMMA  = ",";
    private static final String COLON  = ":";
    private static BASE64Decoder decoder = null;

    public String getUserName(String _authorization)
    {
        return getUserName(_authorization, null);
    }

    public String getUserName(String _authorization, String _defaultName)
    {
        String userName = _defaultName;
        try
        {
            if (_authorization == null)
            {
                userName = _defaultName;
            }
            else
            {
                BASE64Decoder d64 = getBASE64Decoder();
                String encoded = _authorization.substring(BASIC.length());
                String decoded = new String(d64.decodeBuffer(encoded));
                if (decoded.startsWith(CN_KEY))
                {
                    userName = decoded.substring(3, decoded.indexOf(COMMA));
                }
                else
                {
                    int index = decoded.indexOf(COLON);
                    if (index != -1)
                    {
                        userName = decoded.substring(0, index);
                    }
                    else
                    {
                        userName = _defaultName;
                    }
                }
            }
        }
        catch (Exception e)
        {
            e.printStackTrace();
            userName = _defaultName;
        }
        return userName;
    }

//    public String identifyUser(HttpServletRequest request)
//            throws UserDataNotFoundException {
//        String encodedElement = request.getHeader(ID_KEY);
//        log.debug("[ICHAIN] encodedElement: " + encodedElement);
//        if (encodedElement == null) {
//            log.error(
//                    "[ICHAIN] bad data found encodedElement is null: "
//                            + ID_KEY
//                            + " encodedId: "
//                            + encodedElement);
//
//            throw new UserDataNotFoundException(
//                    "[ICHAIN] bad data found encodedElement is null: "
//                            + ID_KEY
//                            + " encodedElement: "
//                            + encodedElement);
//        }
//
//        StringTokenizer st = new StringTokenizer(encodedElement);
//        String encodedId = null;
//        int count = 0;
//
//        //the encoded id should be the second element of the string
//        while (st.hasMoreElements()) {
//            String next = st.nextToken();
//            log.debug("[ICHAIN] next element first encoded: " + next);
//            count++;
//            if (count == 2) {
//                encodedId = next;
//            }
//        }
//
//        if (encodedId == null) {
//            log.error(
//                    "[ICHAIN] bad data found encodedId is null: "
//                            + ID_KEY
//                            + " encodedId: "
//                            + encodedId);
//            throw new UserDataNotFoundException(
//                    "[ICHAIN] bad data found encodedId is null: "
//                            + ID_KEY
//                            + " encodedId: "
//                            + encodedId);
//        }
//        String decoded = EncDecUtil.base64decode(encodedId);
//        String id = null;
//
//        st = new StringTokenizer(decoded, ":");
//        count=0;
//        //first element of the decoded is the userid
//        while(st.hasMoreElements()) {
//            count++;
//            String next = st.nextToken();
//            log.debug("[ICHAIN] next element first encoded: " + next);
//            if(count==1){
//                id=next;
//            }
//        }
//        log.debug("[ICHAIN] decoded: " + decoded);
//        log.debug("[ICHAIN] id: " + id);
//
//        return id;
//    }


    private  BASE64Decoder getBASE64Decoder()
    {
        if (decoder == null)
        {
            decoder = new BASE64Decoder();
        }
        return decoder;
    }
}

