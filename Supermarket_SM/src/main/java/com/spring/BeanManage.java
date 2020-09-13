package com.spring;

import com.service.impl.*;
import view.util.Manage;
import view.util.ViewAssistImpl;

import javax.annotation.Resource;

/**
 * @Author:liamg
 * @Date:2020/9/13
 */

public class BeanManage {


    public static AccountServiceImpl accountService;
    @Resource
    public  void setAccountService(AccountServiceImpl accountService) {
        BeanManage.accountService = accountService;
    }

    public static BuyServiceImpl buyService;
    @Resource
    public void setBuyService(BuyServiceImpl buyService) {
        BeanManage.buyService = buyService;
    }


    public static GoodsServiceImpl goodsService;
    @Resource
    public  void setGoodsService(GoodsServiceImpl goodsService) {
        BeanManage.goodsService = goodsService;
    }


    public static InTableServiceImpl inTableService;
    @Resource
    public void setInTableService(InTableServiceImpl inTableService) {
        BeanManage.inTableService = inTableService;
    }

    public static LogServiceImpl logService;
    @Resource
    public void setLogService(LogServiceImpl logService) {
        BeanManage.logService = logService;
    }

    public static PersonsServiceImpl personsService;
    @Resource
    public void setPersonsService(PersonsServiceImpl personsService) {
        BeanManage.personsService = personsService;
    }

    public static SetViewServiceImpl setViewService;
    @Resource
    public void setSetViewService(SetViewServiceImpl setViewService) {
        BeanManage.setViewService = setViewService;
    }

    public static StockServiceImpl stockService;
    @Resource
    public void setStockService(StockServiceImpl stockService) {
        BeanManage.stockService = stockService;
    }

    public static Manage  stateManagement;
    @Resource
    public void setStateManagement(Manage stateManagement) {
        BeanManage.stateManagement = stateManagement;
    }

    public static ViewAssistImpl viewAssistImpl;

    @Resource(name = "ViewAssistImpl")
    public void setViewAssistImpl(ViewAssistImpl viewAssistImpl) {
        BeanManage.viewAssistImpl = viewAssistImpl;
    }
}
