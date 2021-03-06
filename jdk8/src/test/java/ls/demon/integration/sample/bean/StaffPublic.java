/**
 * Witontek.com.
 * Copyright (c) 2012-2017 All Rights Reserved.
 */
package ls.demon.integration.sample.bean;

import ls.demon.commons.lang.BaseModel;

/**
 * 
 * @author song.li@witontek.com
 * @version $Id: StaffPublic.java, v 0.1 2017年6月15日 下午5:13:45 song.li@witontek.com Exp $
 */
public class StaffPublic extends BaseModel {
    /**  */
    private static final long serialVersionUID = 6611983758756279535L;
    private String            name;
    private int               age;
    private String            extra;

    /**
     * Getter method for property <tt>name</tt>.
     * 
     * @return property value of name
     */
    public String getName() {
        return name;
    }

    /**
     * Setter method for property <tt>name</tt>.
     * 
     * @param name value to be assigned to property name
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Getter method for property <tt>age</tt>.
     * 
     * @return property value of age
     */
    public int getAge() {
        return age;
    }

    /**
     * Setter method for property <tt>age</tt>.
     * 
     * @param age value to be assigned to property age
     */
    public void setAge(int age) {
        this.age = age;
    }

    /**
     * Getter method for property <tt>extra</tt>.
     * 
     * @return property value of extra
     */
    public String getExtra() {
        return extra;
    }

    /**
     * Setter method for property <tt>extra</tt>.
     * 
     * @param extra value to be assigned to property extra
     */
    public void setExtra(String extra) {
        this.extra = extra;
    }

}
