package org.openehealth.ipf.ws.util

import java.text.SimpleDateFormat

/**
 * Created by IntelliJ IDEA.
 * User: 100026806
 * Date: 27.01.11
 * Time: 11:03
 * To change this template use File | Settings | File Templates.
 */
class Convert {

  static String convert(String hl7date) {
      Date date = new SimpleDateFormat("yyyyMMdd").parse(hl7date);
      return new SimpleDateFormat("dd-MMM-yyyy").format(date);
  }

  static String convertDateTime(String hl7DateTime) {
    Date date = new SimpleDateFormat("yyyyMMddhhmmss").parse(hl7DateTime);
    return new SimpleDateFormat("dd-MMM-yyyy").format(date);
  }
   static String getEventDateTime() {
     return new SimpleDateFormat("yyyyMMddHHmm").format(new Date())
   }

}
