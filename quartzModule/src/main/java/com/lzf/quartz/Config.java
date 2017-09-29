package com.lzf.quartz;

import javax.persistence.*;

/**
 * 描述:
 *
 * @outhor liuzhenfei
 * @create 2017-09-26 下午 4:29
 */
@Entity
public class Config {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column
    private String cron;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCron() {
        return cron;
    }

    public void setCron(String cron) {
        this.cron = cron;
    }
}