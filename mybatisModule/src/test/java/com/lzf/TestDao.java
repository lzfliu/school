package com.lzf;

import com.lzf.dao.*;
import com.lzf.entity.*;
import com.lzf.utils.IdGenerater;
import com.lzf.utils.PinYinUtils;
import org.apache.commons.lang3.StringUtils;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.CollectionUtils;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * 描述:
 * 测试mybatisDAO
 *
 * @author liuzhenfei
 * @create 2017-09-20 上午 10:19
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT,classes = MybatisAppaction.class)
public class TestDao {

    private static String stage = "stage";

    private static String online = "online";

    private static String noCheck = "0";

    @Autowired
    private FirmFinancesMapper firmFinancesMapper;

    @Autowired
    private FirmCapitalsMapper firmCapitalsMapper;

    @Autowired
    private FirmDealersMapper firmDealersMapper;

    @Autowired
    private FirmDocumentsMapper firmDocumentsMapper;

    @Autowired
    private FirmHomeVisitsMapper firmHomeVisitsMapper;

    @Autowired
    private FirmInsuresMapper firmInsuresMapper;

    @Autowired
    private SysCompanyMapper sysCompanyMapper;

    @Autowired
    private BizFinancialMapper bizFinancialMapper;

    @Autowired
    private BizChannelMapper bizChannelMapper;

    @Autowired
    private BizCapitalMapper bizCapitalMapper;

    @Autowired
    private BizDocumentMapper bizDocumentMapper;

    @Autowired
    private BizVisitMapper bizVisitMapper;

    @Autowired
    private SysUsersMapper sysUsersMapper;

    @Autowired
    private SysUserMapper sysUserMapper;

    @Autowired
    private ProductsMapper productsMapper;

    @Autowired
    private ProductMapper productMapper;

    @Autowired
    private ProductFlowMapper productFlowMapper;

    @Autowired
    private ProductUsedCarRuleMapper productUsedCarRuleMapper;

    @Autowired
    private ProductLoanMapper productLoanMapper;

    @Autowired
    private Cas1RelationMapper cas1RelationMapper;

    @Autowired
    private DealerProductsForCas1Mapper dealerProductsForCas1Mapper;

    @Autowired
    private DealerProductsMapper dealerProductsMapper;

    @Autowired
    private DealerProductProfitsForCas1Mapper dealerProductProfitsForCas1Mapper;

    @Autowired
    private DealerProductProfitsMapper dealerProductProfitsMapper;

    @Autowired
    private DealerAllocationMapper dealerAllocationMapper;

    @Autowired
    private SysRoleUserRelMapper sysRoleUserRelMapper;

    @Test
    public void importFinances() throws IOException {
        DatabaseContextHolder.setDatabaseType(DatabaseType.mytestdb);
        List<FirmFinances> firmFinances = firmFinancesMapper.selectAll();
        List<SysCompany> list= new ArrayList<>();
        List<BizFinancial> bizFinancialArrayList= new ArrayList<>();
        List<SysUser> userList= new ArrayList<>();
        List<Cas1Relation> cas1RelationList= new ArrayList<>();
        for (FirmFinances firmFinance : firmFinances) {

            SysCompany sysCompany = new SysCompany();
            sysCompany.setId(IdGenerater.uuid());
            sysCompany.setCreatedBy("脚本导入");
            sysCompany.setCreatedOn(new Date());
            sysCompany.setIsDelete((byte) 0);
            sysCompany.setIsAvailable((byte) 1);
            sysCompany.setName(firmFinance.getName());
            sysCompany.setStatus(noCheck);
            sysCompany.setDataType(stage);

            String pinYinHeadChar = PinYinUtils.getPinYinHeadChar(firmFinance.getName());
            if(StringUtils.isBlank(pinYinHeadChar)){
                pinYinHeadChar = IdGenerater.RandomLowerCharater(4);
            }
            sysCompany.setCode(pinYinHeadChar);

            sysCompany.setPhone(firmFinance.getMobile());
            sysCompany.setLinkman(firmFinance.getLinkman());
            sysCompany.setAddress(firmFinance.getAddress());
            sysCompany.setProvince(firmFinance.getProvince());
            sysCompany.setCity(firmFinance.getCity());
            sysCompany.setDistrict(firmFinance.getDistrict());
            sysCompany.setCanAcp(false);
            sysCompany.setCanCapital(false);
            sysCompany.setCanDealer(false);
            sysCompany.setCanHelpMortgage(false);
            sysCompany.setCanSp(false);
            sysCompany.setCanMortgage(false);
            sysCompany.setCanVisit(false);
            sysCompany.setIsQualityDealer(false);

            list.add(sysCompany);

            BizFinancial bizFinancial = new BizFinancial();
            bizFinancial.setId(IdGenerater.uuid());
            bizFinancial.setCreatedBy("脚本导入");
            bizFinancial.setCreatedOn(new Date());
            bizFinancial.setIsDelete(false);
            bizFinancial.setIsAvailable(true);
            bizFinancial.setCompanyId(sysCompany.getId());
            bizFinancial.setStatus(noCheck);
            bizFinancial.setDataType(stage);
            bizFinancialArrayList.add(bizFinancial);

            Cas1Relation cas1Relation = new Cas1Relation();
            cas1Relation.setId(sysCompany.getId());
            cas1Relation.setType("Finance");
            cas1Relation.setCas1Id(firmFinance.getId()+"");
            cas1RelationList.add(cas1Relation);

            SysUsers params = new SysUsers();
            params.setFirmType("Finance");
            params.setFirmId(firmFinance.getId());
            List<SysUsers> usersList = sysUsersMapper.findByParams(params);
            if(!CollectionUtils.isEmpty(usersList)){
                for (SysUsers sysUsers : usersList) {
                    addUser(userList, sysCompany, sysUsers);
                }
            }
        }


        insertCompany(list);

        insertFinancial(bizFinancialArrayList);

        insertCas1Relation(cas1RelationList);

        insertUser(userList);


    }

    @Transactional(value = "transactionManagerForSource2")
    @Rollback(true)// 事务自动回滚，默认是true。可以不写
    public void insertUser(List<SysUser> userList) {
        for (SysUser sysUser : userList) {
            sysUserMapper.insert(sysUser);
        }
    }

    @Transactional(value = "transactionManagerForSource2")
    @Rollback(true)// 事务自动回滚，默认是true。可以不写
    public void insertCas1Relation(List<Cas1Relation> cas1RelationList) {
        DatabaseContextHolder.setDatabaseType(DatabaseType.mytestdb2);
        for (Cas1Relation cas1Relation : cas1RelationList) {
            cas1RelationMapper.insert(cas1Relation);
        }
    }

    @Transactional(value = "transactionManagerForSource2")
    @Rollback(true)// 事务自动回滚，默认是true。可以不写
    public void insertFinancial(List<BizFinancial> bizFinancialArrayList) {
        DatabaseContextHolder.setDatabaseType(DatabaseType.mytestdb2);
        for (BizFinancial bizFinancial : bizFinancialArrayList) {
            bizFinancialMapper.insert(bizFinancial);
        }
    }

    @Transactional(value = "transactionManagerForSource2")
    @Rollback(true)// 事务自动回滚，默认是true。可以不写
    public void insertCompany(List<SysCompany> list) {
        DatabaseContextHolder.setDatabaseType(DatabaseType.mytestdb2);
        for (SysCompany sysCompany : list) {
            sysCompanyMapper.insert(sysCompany);
        }
    }

    @Test
    public void importCapitals() throws IOException {
        DatabaseContextHolder.setDatabaseType(DatabaseType.mytestdb);
        List<FirmCapitals> firmFinances = firmCapitalsMapper.selectAll();
        List<SysCompany> list= new ArrayList<>();
        List<BizCapital> bizCapitalList= new ArrayList<>();
        List<SysUser> userList= new ArrayList<>();
        List<Cas1Relation> cas1RelationList= new ArrayList<>();
        for (FirmCapitals firmCapitals : firmFinances) {
            DatabaseContextHolder.setDatabaseType(DatabaseType.mytestdb2);
            SysCompany sysCompany = sysCompanyMapper.selectByName(firmCapitals.getName());
            if(sysCompany == null ){
                sysCompany = new SysCompany();
                sysCompany.setId(IdGenerater.uuid());
                sysCompany.setCreatedBy("脚本导入");
                sysCompany.setCreatedOn(new Date());
                sysCompany.setIsDelete((byte) 0);
                sysCompany.setIsAvailable((byte) 1);
                sysCompany.setName(firmCapitals.getName());

                String pinYinHeadChar = PinYinUtils.getPinYinHeadChar(firmCapitals.getName());
                if(StringUtils.isBlank(pinYinHeadChar)){
                    pinYinHeadChar = IdGenerater.RandomLowerCharater(4);
                }
                sysCompany.setCode(pinYinHeadChar);


                sysCompany.setPhone(firmCapitals.getLoanPhone());
                sysCompany.setLinkman(firmCapitals.getLinkman());
                sysCompany.setAddress(firmCapitals.getAddress());
                sysCompany.setProvince(firmCapitals.getProvince());
                sysCompany.setCity(firmCapitals.getCity());
                sysCompany.setDistrict(firmCapitals.getDistrict());
                sysCompany.setCanAcp(false);
                sysCompany.setCanCapital(true);
                sysCompany.setCanDealer(false);
                sysCompany.setCanHelpMortgage(false);
                sysCompany.setCanSp(false);
                sysCompany.setCanMortgage(false);
                sysCompany.setCanVisit(false);
                sysCompany.setIsQualityDealer(false);
                sysCompany.setDataType(stage);
                sysCompany.setStatus(noCheck);
                list.add(sysCompany);
            }


            BizCapital bizCapital = new BizCapital();
            bizCapital.setId(IdGenerater.uuid());
            bizCapital.setCreatedBy("脚本导入");
            bizCapital.setCreatedOn(new Date());
            bizCapital.setIsDelete(false);
            bizCapital.setIsAvailable(true);
            bizCapital.setIsNeedAppointment(true);
            bizCapital.setAllowPrivateAccount(firmCapitals.getSupportprivate());
            bizCapital.setCompanyId(sysCompany.getId());
            bizCapital.setFirstBeneficiary(firmCapitals.getFirstBeneficiary());
            bizCapital.setTransferKey("transfer_ccb_ceb");//单证流程
            bizCapital.setDataType(stage);
            bizCapital.setStatus(noCheck);
            bizCapitalList.add(bizCapital);

            Cas1Relation cas1Relation = new Cas1Relation();
            cas1Relation.setId(sysCompany.getId());
            cas1Relation.setType("Capital");
            cas1Relation.setCas1Id(firmCapitals.getId()+"");
            cas1RelationList.add(cas1Relation);

            SysUsers params = new SysUsers();
            params.setFirmType("Capital");
            params.setFirmId(firmCapitals.getId());
            DatabaseContextHolder.setDatabaseType(DatabaseType.mytestdb);
            List<SysUsers> usersList = sysUsersMapper.findByParams(params);

            if(!CollectionUtils.isEmpty(usersList)){
                DatabaseContextHolder.setDatabaseType(DatabaseType.mytestdb2);

                for (SysUsers sysUsers : usersList) {

                    addUser(userList, sysCompany, sysUsers);



                }

            }

        }

        DatabaseContextHolder.setDatabaseType(DatabaseType.mytestdb2);

        insertCompany(list);

        for (BizCapital bizCapital : bizCapitalList) {
            bizCapitalMapper.insert(bizCapital);
        }

        insertCas1Relation(cas1RelationList);


        insertUser(userList);

    }

    private SysUser addUser(List<SysUser> userList, SysCompany sysCompany, SysUsers sysUsers) {
        SysUser sysUser = new SysUser();
        sysUser.setId(IdGenerater.uuid());
        sysUser.setCreatedBy("脚本导入");
        sysUser.setCreatedOn(new Date());
        sysUser.setIsDelete((byte) 0);
        sysUser.setIsAvailable((byte) 1);
        sysUser.setPassword("abcd1234");
        sysUser.setCompany(sysCompany);
        sysUser.setCompanyId(sysCompany.getId());
        sysUser.setLoginName(sysUsers.getUsername());
        sysUser.setRealName(sysUsers.getTruename());
        sysUser.setMobile(sysUsers.getMobile());
        sysUser.setEmail(sysUsers.getEmail());
        sysUser.setGender((byte) 1);
        sysUser.setBirth(null);
        sysUser.setStatus(noCheck);
        sysUser.setDataType(stage);
        sysUser.setFace((byte) 1);
        sysUser.setOnline((byte) 1);
        userList.add(sysUser);
        return sysUser;
    }

    @Test
    public void importDocument() throws IOException {
        DatabaseContextHolder.setDatabaseType(DatabaseType.mytestdb);
        List<FirmDocuments> firmDocumentsList = firmDocumentsMapper.selectAll();
        List<SysCompany> list= new ArrayList<>();
        List<BizDocument> bizDocumentList= new ArrayList<>();
        List<SysUser> userList= new ArrayList<>();
        List<Cas1Relation> cas1RelationList= new ArrayList<>();
        for (FirmDocuments firmDocuments : firmDocumentsList) {
            DatabaseContextHolder.setDatabaseType(DatabaseType.mytestdb2);
            SysCompany sysCompany = sysCompanyMapper.selectByName(firmDocuments.getName());
            if(sysCompany == null ){
                sysCompany = new SysCompany();
                sysCompany.setId(IdGenerater.uuid());
                sysCompany.setCreatedBy("脚本导入");
                sysCompany.setCreatedOn(new Date());
                sysCompany.setIsDelete((byte) 0);
                sysCompany.setIsAvailable((byte) 1);
                sysCompany.setName(firmDocuments.getName());
                String pinYinHeadChar = PinYinUtils.getPinYinHeadChar(firmDocuments.getName());
                sysCompany.setCode(pinYinHeadChar);
                sysCompany.setPhone(firmDocuments.getMobile());
                sysCompany.setLinkman(firmDocuments.getLinkman());
                sysCompany.setAddress(firmDocuments.getAddress());
                sysCompany.setProvince(firmDocuments.getProvince());
                sysCompany.setCity(firmDocuments.getCity());
                sysCompany.setDistrict(firmDocuments.getDistrict());
                sysCompany.setCanAcp(false);
                sysCompany.setCanCapital(false);
                sysCompany.setCanDealer(false);
                sysCompany.setCanHelpMortgage(false);
                sysCompany.setCanSp(false);
                sysCompany.setCanMortgage(false);
                sysCompany.setCanVisit(false);
                sysCompany.setIsQualityDealer(false);
                sysCompany.setDataType(stage);
                sysCompany.setStatus(noCheck);
                list.add(sysCompany);
            }


            BizDocument bizDocument = new BizDocument();
            if("全国总公司".equals(firmDocuments.getName())){
                bizDocument.setId("1234567890");
                bizDocument.setParentId(null);

            }else{
                bizDocument.setId(IdGenerater.uuid());
                bizDocument.setParentId("1234567890");
            }
            bizDocument.setCreatedBy("脚本导入");
            bizDocument.setCreatedOn(new Date());
            bizDocument.setIsDelete(false);
            bizDocument.setIsAvailable(true);
            bizDocument.setDataType(stage);
            bizDocument.setStatus(noCheck);
            bizDocument.setCompanyId(sysCompany.getId());
            bizDocumentList.add(bizDocument);

            Cas1Relation cas1Relation = new Cas1Relation();
            cas1Relation.setId(sysCompany.getId());
            cas1Relation.setType("Document");
            cas1Relation.setCas1Id(firmDocuments.getId()+"");
            cas1RelationList.add(cas1Relation);

            SysUsers params = new SysUsers();
            params.setFirmType("Document");
            params.setFirmId(firmDocuments.getId());

            DatabaseContextHolder.setDatabaseType(DatabaseType.mytestdb);
            List<SysUsers> usersList = sysUsersMapper.findByParams(params);
            if(!CollectionUtils.isEmpty(usersList)){
                DatabaseContextHolder.setDatabaseType(DatabaseType.mytestdb2);
                for (SysUsers sysUsers : usersList) {

                    addUser(userList,sysCompany,sysUsers);
                }

            }
        }

        DatabaseContextHolder.setDatabaseType(DatabaseType.mytestdb2);

        insertCompany(list);

        for (BizDocument bizDocument : bizDocumentList) {
            bizDocumentMapper.insert(bizDocument);
        }

        insertCas1Relation(cas1RelationList);


        insertUser(userList);

    }

    @Test
    public void importHomeVisits() throws IOException {
        DatabaseContextHolder.setDatabaseType(DatabaseType.mytestdb);
        List<FirmHomeVisits> firmHomeVisitsList = firmHomeVisitsMapper.selectAll();
        List<SysCompany> list= new ArrayList<>();
        List<BizVisit> bizVisitList= new ArrayList<>();
        List<SysUser> userList= new ArrayList<>();
        List<Cas1Relation> cas1RelationList= new ArrayList<>();
        for (FirmHomeVisits firmHomeVisits : firmHomeVisitsList) {

            DatabaseContextHolder.setDatabaseType(DatabaseType.mytestdb2);
            SysCompany sysCompany = sysCompanyMapper.selectByName(firmHomeVisits.getName());
            if(sysCompany == null ){
                sysCompany = new SysCompany();
                sysCompany.setId(IdGenerater.uuid());
                sysCompany.setCreatedBy("脚本导入");
                sysCompany.setCreatedOn(new Date());
                sysCompany.setIsDelete((byte) 0);
                sysCompany.setIsAvailable((byte) 1);
                sysCompany.setName(firmHomeVisits.getName());

                String pinYinHeadChar = PinYinUtils.getPinYinHeadChar(firmHomeVisits.getName());
                sysCompany.setCode(pinYinHeadChar);

                sysCompany.setPhone(firmHomeVisits.getMobile());
                sysCompany.setLinkman(firmHomeVisits.getContactMan());
                sysCompany.setAddress(firmHomeVisits.getAddress());
                sysCompany.setProvince(firmHomeVisits.getProvince());
                sysCompany.setCity(firmHomeVisits.getCity());
                sysCompany.setDistrict(firmHomeVisits.getDistrict());
                sysCompany.setCanAcp(false);
                sysCompany.setCanCapital(false);
                sysCompany.setCanDealer(false);
                sysCompany.setCanHelpMortgage(false);
                sysCompany.setCanSp(false);
                sysCompany.setCanMortgage(false);
                sysCompany.setCanVisit(false);
                sysCompany.setIsQualityDealer(false);
                sysCompany.setStatus(noCheck);
                sysCompany.setDataType(stage);
                list.add(sysCompany);
            }


            BizVisit bizVisit = new BizVisit();
            bizVisit.setId(IdGenerater.uuid());
            bizVisit.setCreatedBy("脚本导入");
            bizVisit.setCreatedOn(new Date());
            bizVisit.setIsDelete(false);
            bizVisit.setIsAvailable(true);
            bizVisit.setCompanyId(sysCompany.getId());
            bizVisit.setStatus(noCheck);
            bizVisit.setDataType(stage);
            bizVisitList.add(bizVisit);

            Cas1Relation cas1Relation = new Cas1Relation();
            cas1Relation.setId(sysCompany.getId());
            cas1Relation.setType("HomeVisit");
            cas1Relation.setCas1Id(firmHomeVisits.getId()+"");
            cas1RelationList.add(cas1Relation);

            SysUsers params = new SysUsers();
            params.setFirmType("HomeVisit");
            params.setFirmId(firmHomeVisits.getId());

            DatabaseContextHolder.setDatabaseType(DatabaseType.mytestdb);
            List<SysUsers> usersList = sysUsersMapper.findByParams(params);
            if(!CollectionUtils.isEmpty(usersList)){
                DatabaseContextHolder.setDatabaseType(DatabaseType.mytestdb2);

                for (SysUsers sysUsers : usersList) {
                    addUser(userList,sysCompany,sysUsers);
                }
            }

        }

        DatabaseContextHolder.setDatabaseType(DatabaseType.mytestdb2);

        insertCompany(list);

        for (BizVisit bizVisit : bizVisitList) {
            bizVisitMapper.insert(bizVisit);
        }

        insertCas1Relation(cas1RelationList);


        insertUser(userList);

    }

    @Test
    public void importInsures() throws IOException {
        DatabaseContextHolder.setDatabaseType(DatabaseType.mytestdb);
        List<FirmInsures> firmInsuresList = firmInsuresMapper.selectAll();
        List<SysCompany> list= new ArrayList<>();
        List<SysUser> userList= new ArrayList<>();
        List<Cas1Relation> cas1RelationList= new ArrayList<>();
        for (FirmInsures firmInsures : firmInsuresList) {

            DatabaseContextHolder.setDatabaseType(DatabaseType.mytestdb2);
            SysCompany sysCompany = sysCompanyMapper.selectByName(firmInsures.getName());
            if(sysCompany == null ){
                sysCompany = new SysCompany();
                sysCompany.setId(IdGenerater.uuid());
                sysCompany.setCreatedBy("脚本导入");
                sysCompany.setCreatedOn(new Date());
                sysCompany.setIsDelete((byte) 0);
                sysCompany.setIsAvailable((byte) 1);
                sysCompany.setName(firmInsures.getName());
                String pinYinHeadChar = PinYinUtils.getPinYinHeadChar(firmInsures.getName());
                sysCompany.setCode(pinYinHeadChar);
                sysCompany.setPhone(firmInsures.getMobile());
                sysCompany.setLinkman(firmInsures.getLinkman());
                sysCompany.setAddress(firmInsures.getAddress());
                sysCompany.setProvince(firmInsures.getProvince());
                sysCompany.setCity(firmInsures.getCity());
                sysCompany.setDistrict(firmInsures.getDistrict());
                sysCompany.setCanAcp(false);
                sysCompany.setCanCapital(false);
                sysCompany.setCanDealer(false);
                sysCompany.setCanHelpMortgage(false);
                sysCompany.setCanSp(false);
                sysCompany.setCanMortgage(false);
                sysCompany.setCanVisit(false);
                sysCompany.setIsQualityDealer(false);
                sysCompany.setDataType(stage);
                sysCompany.setStatus(noCheck);
                list.add(sysCompany);
            }

            Cas1Relation cas1Relation = new Cas1Relation();
            cas1Relation.setId(sysCompany.getId());
            cas1Relation.setType("Insure");
            cas1Relation.setCas1Id(firmInsures.getId()+"");
            cas1RelationList.add(cas1Relation);

            SysUsers params = new SysUsers();
            params.setFirmType("Insure");
            params.setFirmId(firmInsures.getId());

            DatabaseContextHolder.setDatabaseType(DatabaseType.mytestdb);
            List<SysUsers> usersList = sysUsersMapper.findByParams(params);
            if(!CollectionUtils.isEmpty(usersList)){
                DatabaseContextHolder.setDatabaseType(DatabaseType.mytestdb2);

                for (SysUsers sysUsers : usersList) {
                    addUser(userList,sysCompany,sysUsers);
                }

            }

        }

        DatabaseContextHolder.setDatabaseType(DatabaseType.mytestdb2);

        insertCompany(list);

        insertCas1Relation(cas1RelationList);

        insertUser(userList);

    }
//
//    @Test
//    public void importMortgage() throws IOException {
//
//    }
//
    @Test
    public void importACP() throws IOException {
        DatabaseContextHolder.setDatabaseType(DatabaseType.mytestdb);
        List<FirmDealers> firmDealersList = firmDealersMapper.selectACP();
        List<SysCompany> list= new ArrayList<>();
        List<BizChannel> bizChannelList= new ArrayList<>();
        List<SysUser> userList= new ArrayList<>();
        List<SysRoleUserRel> sysRoleUserRels= new ArrayList<>();
        List<Cas1Relation> relationList = new ArrayList<>();
        for (FirmDealers firmDealers : firmDealersList) {

            Cas1Relation cas1Relation = new Cas1Relation();
            cas1Relation.setId(IdGenerater.uuid());
            cas1Relation.setType("Dealer");
            cas1Relation.setCas1Id(firmDealers.getId()+"");
            relationList.add(cas1Relation);

            DatabaseContextHolder.setDatabaseType(DatabaseType.mytestdb2);
            SysCompany sysCompany = sysCompanyMapper.selectByName(firmDealers.getName());
            if(sysCompany == null ){
                sysCompany = new SysCompany();
                sysCompany.setId(cas1Relation.getId());
                sysCompany.setCreatedBy("脚本导入");
                sysCompany.setCreatedOn(new Date());
                sysCompany.setIsDelete((byte) 0);
                sysCompany.setIsAvailable((byte) 1);
                sysCompany.setName(firmDealers.getName());
                sysCompany.setPhone(firmDealers.getMobile());
                sysCompany.setLinkman(firmDealers.getLinkman());
                sysCompany.setAddress(firmDealers.getAddress());
                sysCompany.setProvince(firmDealers.getProvince());
                sysCompany.setCity(firmDealers.getCity());
                sysCompany.setDistrict(firmDealers.getDistrict());
                sysCompany.setCreditCode(firmDealers.getEnterpriseCode());//营业执照编号
                sysCompany.setCanAcp(true);
                sysCompany.setCanSp(false);
                sysCompany.setCanDealer(false);
                sysCompany.setCanCapital(false);
                sysCompany.setCanHelpMortgage(false);
                sysCompany.setCanMortgage(false);
                sysCompany.setCanVisit(false);
                sysCompany.setStatus(noCheck);
                sysCompany.setDataType(stage);
                if(firmDealers.getIsGood()!= null && firmDealers.getIsGood() == 1){
                    sysCompany.setIsQualityDealer(true);
                }else{
                    sysCompany.setIsQualityDealer(false);
                }
                list.add(sysCompany);
            }


            BizChannel bizChannel = new BizChannel();
            bizChannel.setId(sysCompany.getId());
            bizChannel.setCreatedBy("脚本导入");
            bizChannel.setCreatedOn(new Date());
            bizChannel.setIsDelete((byte) 0);
            bizChannel.setIsAvailable((byte) 1);
            bizChannel.setCompanyId(sysCompany.getId());
            bizChannel.setChannelRole("acp");
            bizChannel.setParentId(null);
            bizChannel.setStatus(noCheck);
            bizChannel.setDataType(stage);
            bizChannel.setTrustAccountNo(firmDealers.getTrusteeshipCard());
            bizChannel.setReciveAccountNo(firmDealers.getCollectionCard());
            bizChannel.setReciveAccountBank(firmDealers.getCollectionCardBank());
            bizChannelList.add(bizChannel);

            DatabaseContextHolder.setDatabaseType(DatabaseType.mytestdb);
            SysUsers params = new SysUsers();
            params.setFirmType("Dealer");
            params.setFirmId(firmDealers.getId());


            List<SysUsers> usersList = sysUsersMapper.findByParams(params);
            if(!CollectionUtils.isEmpty(usersList)){
                DatabaseContextHolder.setDatabaseType(DatabaseType.mytestdb2);
                for (SysUsers sysUsers : usersList) {
                    SysUser sysUser = addUser(userList, sysCompany, sysUsers);

                    SysRoleUserRel sysRoleUserRel = new SysRoleUserRel();
                    sysRoleUserRel.setUserId(sysUser.getId());
                    sysRoleUserRel.setRoleId("8af2a5751c593255bfea42a3b8c65e56");//ACP-管理员
                    sysRoleUserRels.add(sysRoleUserRel);

                }

            }

        }

        DatabaseContextHolder.setDatabaseType(DatabaseType.mytestdb2);

        insertCompany(list);

        for (BizChannel bizChannel : bizChannelList) {
            bizChannelMapper.insert(bizChannel);
        }

        insertCas1Relation(relationList);


        insertUser(userList);

        for (SysRoleUserRel sysRoleUserRel : sysRoleUserRels) {
            sysRoleUserRelMapper.insert(sysRoleUserRel);
        }

    }

    @Test
    public void importSP() throws IOException {
        DatabaseContextHolder.setDatabaseType(DatabaseType.mytestdb);
        List<FirmDealers> firmDealersList = firmDealersMapper.selectSP();
        List<SysCompany> list= new ArrayList<>();
        List<BizChannel> bizChannelList= new ArrayList<>();
        List<SysUser> userList= new ArrayList<>();
        List<SysRoleUserRel> sysRoleUserRels= new ArrayList<>();
        List<Cas1Relation> relationList = new ArrayList<>();
        for (FirmDealers firmDealers : firmDealersList) {

            Cas1Relation cas1Relation = new Cas1Relation();
            cas1Relation.setId(IdGenerater.uuid());
            cas1Relation.setType("Dealer");
            cas1Relation.setCas1Id(firmDealers.getId()+"");
            relationList.add(cas1Relation);

            DatabaseContextHolder.setDatabaseType(DatabaseType.mytestdb2);
            SysCompany sysCompany = sysCompanyMapper.selectByName(firmDealers.getName());
            if(sysCompany == null ){
                sysCompany = new SysCompany();
                sysCompany.setId(cas1Relation.getId());
                sysCompany.setCreatedBy("脚本导入");
                sysCompany.setCreatedOn(new Date());
                sysCompany.setIsDelete((byte) 0);
                sysCompany.setIsAvailable((byte) 1);
                sysCompany.setName(firmDealers.getName());
                sysCompany.setPhone(firmDealers.getMobile());
                sysCompany.setLinkman(firmDealers.getLinkman());
                sysCompany.setAddress(firmDealers.getAddress());
                sysCompany.setProvince(firmDealers.getProvince());
                sysCompany.setCity(firmDealers.getCity());
                sysCompany.setDistrict(firmDealers.getDistrict());
                sysCompany.setCreditCode(firmDealers.getEnterpriseCode());//营业执照编号
                sysCompany.setCanAcp(false);
                sysCompany.setCanSp(true);
                sysCompany.setCanDealer(false);
                sysCompany.setCanCapital(false);
                sysCompany.setCanHelpMortgage(false);
                sysCompany.setCanMortgage(false);
                sysCompany.setCanVisit(false);
                sysCompany.setDataType(stage);
                sysCompany.setStatus(noCheck);
                list.add(sysCompany);
            }



            BizChannel bizChannel = new BizChannel();
            bizChannel.setId(sysCompany.getId());
            bizChannel.setCreatedBy("脚本导入");
            bizChannel.setCreatedOn(new Date());
            bizChannel.setIsDelete((byte) 0);
            bizChannel.setIsAvailable((byte) 1);
            bizChannel.setCompanyId(sysCompany.getId());
            bizChannel.setChannelRole("sp");
            bizChannel.setStatus(noCheck);
            bizChannel.setDataType(stage);
            if(firmDealers.getIsGood()!= null && firmDealers.getIsGood() == 1){
                bizChannel.setQualityDealer(true);
            }else{
                bizChannel.setQualityDealer(false);
            }
            DatabaseContextHolder.setDatabaseType(DatabaseType.mytestdb2);
            Cas1Relation cas1RelationParams = new Cas1Relation();
            cas1RelationParams.setType("Dealer");
            cas1RelationParams.setCas1Id(firmDealers.getpId()+"");
            try {
                Cas1Relation cas1RelationForParent =  cas1RelationMapper.findByParams(cas1RelationParams);
                bizChannel.setParentId(cas1RelationForParent.getId());
            }catch (Exception e){
               throw new RuntimeException("查询异常");
            }



            bizChannel.setTrustAccountNo(firmDealers.getTrusteeshipCard());
            bizChannel.setReciveAccountNo(firmDealers.getCollectionCard());
            bizChannel.setReciveAccountBank(firmDealers.getCollectionCardBank());
            bizChannelList.add(bizChannel);


            DatabaseContextHolder.setDatabaseType(DatabaseType.mytestdb);
            SysUsers params = new SysUsers();
            params.setFirmType("Dealer");
            params.setFirmId(firmDealers.getId());

            List<SysUsers> usersList = sysUsersMapper.findByParams(params);
            if(!CollectionUtils.isEmpty(usersList)){
                DatabaseContextHolder.setDatabaseType(DatabaseType.mytestdb2);
                for (SysUsers sysUsers : usersList) {

                    SysUser sysUser = addUser(userList, sysCompany, sysUsers);
                    SysRoleUserRel sysRoleUserRel = new SysRoleUserRel();
                    sysRoleUserRel.setUserId(sysUser.getId());
                    sysRoleUserRel.setRoleId("d498fc26bbf964740f50cecd6336c7b9");//SP-管理员
                    sysRoleUserRels.add(sysRoleUserRel);
                }

            }

        }

        DatabaseContextHolder.setDatabaseType(DatabaseType.mytestdb2);

        insertCompany(list);

        for (BizChannel bizChannel : bizChannelList) {
            bizChannelMapper.insert(bizChannel);
        }

        insertCas1Relation(relationList);


        insertUser(userList);

        for (SysRoleUserRel sysRoleUserRel : sysRoleUserRels) {
            sysRoleUserRelMapper.insert(sysRoleUserRel);
        }
    }

    @Test
    public void importDealer() throws IOException {
        DatabaseContextHolder.setDatabaseType(DatabaseType.mytestdb);
        List<FirmDealers> firmDealersList = firmDealersMapper.selectDealer();
        List<SysCompany> list= new ArrayList<>();
        List<BizChannel> bizChannelList= new ArrayList<>();
        List<SysUser> userList= new ArrayList<>();
        List<SysRoleUserRel> sysRoleUserRels= new ArrayList<>();
        List<Cas1Relation> relationList = new ArrayList<>();
        for (FirmDealers firmDealers : firmDealersList) {

            Cas1Relation cas1Relation = new Cas1Relation();
            cas1Relation.setId(IdGenerater.uuid());
            cas1Relation.setType("Dealer");
            cas1Relation.setCas1Id(firmDealers.getId()+"");
            relationList.add(cas1Relation);

            DatabaseContextHolder.setDatabaseType(DatabaseType.mytestdb2);
            SysCompany sysCompany = sysCompanyMapper.selectByName(firmDealers.getName());
            if(sysCompany == null ){
                sysCompany = new SysCompany();
                sysCompany.setId(cas1Relation.getId());
                sysCompany.setCreatedBy("脚本导入");
                sysCompany.setCreatedOn(new Date());
                sysCompany.setIsDelete((byte) 0);
                sysCompany.setIsAvailable((byte) 1);
                sysCompany.setName(firmDealers.getName());
                sysCompany.setPhone(firmDealers.getMobile());
                sysCompany.setLinkman(firmDealers.getLinkman());
                sysCompany.setAddress(firmDealers.getAddress());
                sysCompany.setProvince(firmDealers.getProvince());
                sysCompany.setCity(firmDealers.getCity());
                sysCompany.setDistrict(firmDealers.getDistrict());
                sysCompany.setCreditCode(firmDealers.getEnterpriseCode());//营业执照编号
                sysCompany.setCanAcp(false);
                sysCompany.setCanSp(false);
                sysCompany.setCanDealer(true);
                sysCompany.setCanCapital(false);
                sysCompany.setCanHelpMortgage(false);
                sysCompany.setCanMortgage(false);
                sysCompany.setCanVisit(false);
                if(firmDealers.getIsGood()!= null && firmDealers.getIsGood() == 1){
                    sysCompany.setIsQualityDealer(true);
                }else{
                    sysCompany.setIsQualityDealer(false);
                }
                list.add(sysCompany);
            }



            BizChannel bizChannel = new BizChannel();
            bizChannel.setId(IdGenerater.uuid());
            bizChannel.setCreatedBy("脚本导入");
            bizChannel.setCreatedOn(new Date());
            bizChannel.setIsDelete((byte) 0);
            bizChannel.setIsAvailable((byte) 1);
            bizChannel.setCompanyId(sysCompany.getId());
            bizChannel.setChannelRole("dealer");
            DatabaseContextHolder.setDatabaseType(DatabaseType.mytestdb2);
            Integer pId = firmDealers.getpId();
            if(pId != 0){
                Cas1Relation cas1RelationParams = new Cas1Relation();
                cas1RelationParams.setType("Dealer");
                cas1RelationParams.setCas1Id(firmDealers.getpId()+"");

                try {
                    Cas1Relation cas1RelationForParent =  cas1RelationMapper.findByParams(cas1RelationParams);
                    bizChannel.setParentId(cas1RelationForParent.getId());
                }catch (Exception e){
                    throw new RuntimeException("查询异常");
                }
            }else{
                bizChannel.setParentId(null);
            }

            bizChannel.setTrustAccountNo(firmDealers.getTrusteeshipCard());
            bizChannel.setReciveAccountNo(firmDealers.getCollectionCard());
            bizChannel.setReciveAccountBank(firmDealers.getCollectionCardBank());
            bizChannelList.add(bizChannel);


            DatabaseContextHolder.setDatabaseType(DatabaseType.mytestdb);
            SysUsers params = new SysUsers();
            params.setFirmType("Dealer");
            params.setFirmId(firmDealers.getId());
            List<SysUsers> usersList = sysUsersMapper.findByParams(params);
            if(!CollectionUtils.isEmpty(usersList)){
                DatabaseContextHolder.setDatabaseType(DatabaseType.mytestdb2);
                for (SysUsers sysUsers : usersList) {
                    SysUser sysUser = addUser(userList, sysCompany, sysUsers);
                    SysRoleUserRel sysRoleUserRel = new SysRoleUserRel();
                    sysRoleUserRel.setUserId(sysUser.getId());
                    sysRoleUserRel.setRoleId("a10176e7073f17a1e8d50f8fd32562d0");//经销商业务员
                    sysRoleUserRels.add(sysRoleUserRel);

                }

            }

        }

        DatabaseContextHolder.setDatabaseType(DatabaseType.mytestdb2);

        insertCompany(list);

        for (BizChannel bizChannel : bizChannelList) {
            bizChannelMapper.insert(bizChannel);
        }

        insertCas1Relation(relationList);


        insertUser(userList);

        for (SysRoleUserRel sysRoleUserRel : sysRoleUserRels) {
            sysRoleUserRelMapper.insert(sysRoleUserRel);
        }

    }


//    @Test
//    public void testUser() throws IOException {
//        DatabaseContextHolder.setDatabaseType(DatabaseType.mytestdb2);
//        SysUser sysUser = sysUserMapper.selectByPrimaryKey("ba45676c6e9c47bca441115b6a5d266c");
//        String companyId = sysUser.getCompanyId();
//        SysCompany sysCompany = sysCompanyMapper.selectByPrimaryKey(companyId);
//        sysUser.setCompany(sysCompany);
//        sysUser.setId(IdGenerater.uuid());
//        sysUser.setLoginName("runoit");
//        String  coreUserId = saveCustomerStaff(sysUser);
//        sysUser.setCoreStaffId(coreUserId);
//        sysUserMapper.insert(sysUser);
//    }
//

//    @Test
//    public void importProduct() throws IOException{
//        DatabaseContextHolder.setDatabaseType(DatabaseType.mytestdb);
//        List<Products> productsList = productsMapper.selectByProducts();
//        List<Product> productListForCas2 = new ArrayList<>();
//        List<ProductFlow> productFlowListForCas2 = new ArrayList<>();
//        List<ProductLoan> productLoanListForCas2 = new ArrayList<>();
//        List<ProductUsedCarRule> productUsedCarRuleListForCas2 = new ArrayList<>();
//        List<Cas1Relation> cas1RelationList = new ArrayList<>();
//        for (Products products : productsList) {
//            Product cas2Product = new Product();
//            cas2Product.setId(IdGenerater.uuid());
//            cas2Product.setCreatedBy("脚本导入");
//            cas2Product.setCreatedOn(new Date());
//            cas2Product.setIsDelete((byte) 0);
//            cas2Product.setIsAvailable((byte) 1);
//            cas2Product.setCode(products.getCode());
//            cas2Product.setExamine((byte) 1);
//            cas2Product.setStatus("1");
//            cas2Product.setIsRobbery(false);
//            cas2Product.setIsGps(false);
//            cas2Product.setIsMatchLoanyear("0");
//            cas2Product.setName(products.getName());
//            cas2Product.setDescribes(products.getDescribe());
//            if(products.getIsGuakao() != null && products.getIsGuakao()){
//                cas2Product.setBusinessType("[\"natural_affiliated\"]");
//                cas2Product.setIsAffiliated(true);
//            }else{
//                cas2Product.setBusinessType("[\"natural\"]");
//                cas2Product.setIsAffiliated(false);
//            }
//            if(products.getUsedCar()){
//                cas2Product.setProductType("2");
//                if(StringUtils.isNotBlank(products.getMaxKm())){
//                    cas2Product.setMaxMileage(Double.parseDouble(products.getMaxKm()));
//                }
//                cas2Product.setMaterialPackageId("010895c340ff4ffb807a2ba68c760c7f");
//                String carageLimit = products.getCarageLimit();
//                if(StringUtils.isNotBlank(carageLimit) && !"0".equals(carageLimit)){
//                    List<JSONObject> jsonObjects = JSONArray.parseArray(carageLimit, JSONObject.class);
//                    for (JSONObject jsonObject : jsonObjects) {
//                        ProductUsedCarRule productUsedCarRule = new ProductUsedCarRule();
//                        productUsedCarRule.setId(IdGenerater.uuid());
//                        productUsedCarRule.setCreatedBy("脚本导入");
//                        productUsedCarRule.setCreatedOn(new Date());
//                        productUsedCarRule.setIsDelete((byte) 0);
//                        productUsedCarRule.setIsAvailable((byte) 1);
//                        productUsedCarRule.setProductId(cas2Product.getId());
//                        productUsedCarRule.setMinAmount(jsonObject.getBigDecimal("min"));
//                        productUsedCarRule.setMaxAmount(jsonObject.getBigDecimal("max"));
//                        productUsedCarRule.setYear(jsonObject.getDouble("year"));
//                        productUsedCarRuleListForCas2.add(productUsedCarRule);
//                    }
//                }
//            }else{
//                cas2Product.setProductType("1");
//                cas2Product.setMaterialPackageId("5d5feb3c5ea265d52937f4eff425f495");
//            }
//            cas2Product.setIsImprest(products.getIsImprest());
//            cas2Product.setRepayType(products.getRepaymentType());
//            cas2Product.setPerUpper(0);
//            cas2Product.setFirstUpper(Integer.parseInt(products.getMinLoan()));
//            cas2Product.setInsuranceProductCode("");//盗抢产品编码
//            cas2Product.setMinDownPayment(JSON.parseObject(products.getDownpaymentRateRange()).getBigDecimal("min"));
//            cas2Product.setMaxDownPayment(JSON.parseObject(products.getDownpaymentRateRange()).getBigDecimal("max"));
//            cas2Product.setMinLoan(JSON.parseObject(products.getLoanmoneyRange()).getBigDecimal("min"));
//            cas2Product.setMaxLoan(JSON.parseObject(products.getLoanmoneyRange()).getBigDecimal("max"));
//            cas2Product.setMaxLoanRate(products.getLoanrate());
//            cas2Product.setOverrate(products.getOverrate());
//
//            String overloanFormulaId = products.getOverloanFormulaId();//CAS1 超融公式
//
//            if("11".equals(overloanFormulaId)){
//                cas2Product.setOverrateFormulaId("calculationFinancialAmountForPrincipal");
//            }else{
//                cas2Product.setOverrateFormulaId("calculationFinancialAmountForCarPrice");
//            }
//            cas2Product.setOverdraftFormulaId("calculationOverdraft");//透支总额
//            Byte formulaId = products.getProductLoansList().get(0).getFormulaId();//CAS1 月供公式
//            if(9 == formulaId){
//                cas2Product.setOverrateFormulaId("calculationYearMonthlyCompoundInterest");
//            }else{
//                cas2Product.setOverrateFormulaId("calculationAccrualMonthlyRate");
//            }
//            cas2Product.setBaofeiFormulaId("calculationPremium");
//            Boolean intOver = products.getIntOver();
//            String baoeFormulaId = products.getBaoeFormulaId();
//            if("4".equals(baoeFormulaId)){
//                cas2Product.setBaoeFormulaId("calculationBaoeForOverdraft");
//            }else{
//                cas2Product.setBaoeFormulaId("calculationBaoeForTotalAmount");
//            }
//            if(intOver){
//                cas2Product.setLoanamountFormulaId("calculationTotalAmountForRoundUp");
//            }else{
//                cas2Product.setLoanamountFormulaId("calculationTotalAmount");
//            }
//            cas2Product.setDiscount("no"); //是否贴息
//            cas2Product.setCapitalCompanyId("");//资方公司
//            Byte feerate = products.getFeerate();
//            if(1 == feerate){
//                cas2Product.setFeerate(2);
//            }else {
//                cas2Product.setFeerate(1);
//            }
//            List<ProductLoans> productLoansList = products.getProductLoansList();
//            for (ProductLoans productLoans : productLoansList) {
//                ProductLoan productLoan = new ProductLoan();
//                productLoan.setId(IdGenerater.uuid());
//                productLoan.setCreatedBy("脚本导入");
//                productLoan.setCreatedOn(new Date());
//                productLoan.setIsDelete((byte) 0);
//                productLoan.setIsAvailable((byte) 1);
//                productLoan.setProductId(cas2Product.getId());
//
//                productLoan.setMonthNum(productLoans.getMonthNum().toString());
//                productLoan.setManageFeeType("1");
//                productLoan.setManageFee(new BigDecimal(productLoans.getManageFee()));
//                productLoan.setInterest(new BigDecimal(productLoans.getInterest()));
//                productLoan.setRent(new BigDecimal(productLoans.getRent()));
//                productLoan.setInsuranceRate(new BigDecimal(productLoans.getBaoxianRate()));
//                productLoan.setInsuranceMultiRate(new BigDecimal(productLoans.getBaoxianbeiRate()));
//                productLoan.setMonthStatus(true);
//                productLoanListForCas2.add(productLoan);
//            }
//
//            ProductFlow productFlow = new ProductFlow();
//            productFlow.setId(IdGenerater.uuid());
//            productFlow.setCreatedBy("脚本导入");
//            productFlow.setCreatedOn(new Date());
//            productFlow.setIsDelete(false);
//            productFlow.setIsAvailable(true);
//            productFlow.setProductId(cas2Product.getId());
//            productFlow.setQualificationTemplateId("qualification");
//            productFlow.setLoanTemplateId("loanApproval");
//            productFlow.setInsuranceTemplateId("insurance");
//            productFlow.setCapitalTemplateId("shjz_capital");
//            productFlow.setPledgeTemplateId("mortgage");
//            productFlow.setNeedInsurance((byte) 1);
//            productFlowListForCas2.add(productFlow);
//            productListForCas2.add(cas2Product);
//
//            Cas1Relation cas1Relation = new Cas1Relation();
//            cas1Relation.setId(cas2Product.getId());
//            cas1Relation.setType("Product");
//            cas1Relation.setCas1Id(products.getId()+"");
//            cas1RelationList.add(cas1Relation);
//
//        }
//        DatabaseContextHolder.setDatabaseType(DatabaseType.mytestdb2);
//        for (Product product : productListForCas2) {
//            productMapper.insert(product);
//        }
//        for (ProductLoan productLoan : productLoanListForCas2) {
//            productLoanMapper.insert(productLoan);
//        }
//
//        for (ProductFlow productFlow : productFlowListForCas2) {
//            productFlowMapper.insert(productFlow);
//        }
//        for (ProductUsedCarRule productUsedCarRule : productUsedCarRuleListForCas2) {
//            productUsedCarRuleMapper.insert(productUsedCarRule);
//        }
//
//        for (Cas1Relation cas1Relation : cas1RelationList) {
//            cas1RelationMapper.insert(cas1Relation);
//        }
//
//    }
//
//    //TODO 导入经销商单证抵押关系、经销商产品关系、经销商产品佣金关系
//    @Test
//    public void importDealerProduct() throws IOException{
//        DatabaseContextHolder.setDatabaseType(DatabaseType.mytestdb);
//        List<DealerProductsForCas1> dealerProductsForCas1s = dealerProductsForCas1Mapper.selectAll();
//        DatabaseContextHolder.setDatabaseType(DatabaseType.mytestdb2);
//        List<DealerProducts> dealerProductsList = new ArrayList<>();
//        List<Cas1Relation> cas1RelationList = new ArrayList<>();
//        for (DealerProductsForCas1 dealerProductsForCas1 : dealerProductsForCas1s) {
//            Integer dealerId = dealerProductsForCas1.getDealerId();
//            Integer productId = dealerProductsForCas1.getProductId();
//
//            Cas1Relation cas1RelationParams = new Cas1Relation();
//
//            cas1RelationParams.setType("Product");
//            cas1RelationParams.setCas1Id(productId+"");
//            Cas1Relation cas1RelationForProduct = cas1RelationMapper.findByParams(cas1RelationParams);
//            if(cas1RelationForProduct != null){
//                cas1RelationParams.setType("Dealer");
//                cas1RelationParams.setCas1Id(dealerId+"");
//                Cas1Relation cas1RelationForDealer = cas1RelationMapper.findByParams(cas1RelationParams);
//
//                DealerProducts dealerProducts = new DealerProducts();
//                dealerProducts.setId(IdGenerater.uuid());
//                dealerProducts.setCreatedBy("脚本导入");
//                dealerProducts.setCreatedOn(new Date());
//                dealerProducts.setIsDelete((byte) 0);
//                dealerProducts.setIsAvailable((byte) 1);
//                dealerProducts.setCompanyId(cas1RelationForDealer.getId());
//                dealerProducts.setProductId(cas1RelationForProduct.getId());
//                dealerProductsList.add(dealerProducts);
//
//
//                Cas1Relation cas1Relation = new Cas1Relation();
//                cas1Relation.setId(dealerProducts.getId());
//                cas1Relation.setType("DealerProduct");
//                cas1Relation.setCas1Id(dealerProductsForCas1.getId()+"");
//                cas1Relation.setCas1Id(dealerProductsForCas1.getId()+"");
//                cas1RelationList.add(cas1Relation);
//            }
//
//        }
//
//        for (DealerProducts dealerProducts : dealerProductsList) {
//            dealerProductsMapper.insert(dealerProducts);
//        }
//
//        for (Cas1Relation cas1Relation : cas1RelationList) {
//            cas1RelationMapper.insert(cas1Relation);
//        }
//    }
//
//    @Test
//    public void importDealerProductProfits() throws IOException{
//        DatabaseContextHolder.setDatabaseType(DatabaseType.mytestdb);
//        List<DealerProductProfitsForCas1> dealerProductProfitsForCas1s = dealerProductProfitsForCas1Mapper.selectAll();
//        DatabaseContextHolder.setDatabaseType(DatabaseType.mytestdb2);
//        List<DealerProductProfits> dealerProductProfitsList = new ArrayList<>();
//        for (DealerProductProfitsForCas1 dealerProductProfitsForCas1 : dealerProductProfitsForCas1s) {
//            Integer dealerProductId = dealerProductProfitsForCas1.getDealerProductId();
//
//            Cas1Relation cas1RelationParams = new Cas1Relation();
//            cas1RelationParams.setType("DealerProduct");
//            cas1RelationParams.setCas1Id(dealerProductId+"");
//            Cas1Relation cas1RelationForDealerProduct = cas1RelationMapper.findByParams(cas1RelationParams);
//
//            if(cas1RelationForDealerProduct == null){
//                continue;
//            }
//
//            Integer dealerId = dealerProductProfitsForCas1.getDealerId();
//            cas1RelationParams.setType("Dealer");
//            cas1RelationParams.setCas1Id(dealerId+"");
//            Cas1Relation cas1RelationForDealer = cas1RelationMapper.findByParams(cas1RelationParams);
//
//            Integer business = dealerProductProfitsForCas1.getBusiness();
//
//            DealerProductProfits dealerProductProfitsOne = new DealerProductProfits();
//            dealerProductProfitsOne.setId(IdGenerater.uuid());
//            dealerProductProfitsOne.setCreatedBy("脚本导入");
//            dealerProductProfitsOne.setCreatedOn(new Date());
//            dealerProductProfitsOne.setIsDelete((byte) 0);
//            dealerProductProfitsOne.setIsAvailable((byte) 1);
//            dealerProductProfitsOne.setCompanyId(cas1RelationForDealer.getId());
//            getChannelRole(dealerProductProfitsOne, business);
//            dealerProductProfitsOne.setDealerProductId(cas1RelationForDealerProduct.getId());
//            dealerProductProfitsOne.setLoanPeriod("12");
//            dealerProductProfitsOne.setPrice(new BigDecimal(dealerProductProfitsForCas1.getOnePrice()));
//            dealerProductProfitsOne.setProfit(new BigDecimal(dealerProductProfitsForCas1.getOneProfit()));
//
//            DealerProductProfits dealerProductProfitsTwo = new DealerProductProfits();
//            dealerProductProfitsTwo.setId(IdGenerater.uuid());
//            dealerProductProfitsTwo.setCreatedBy("脚本导入");
//            dealerProductProfitsTwo.setCreatedOn(new Date());
//            dealerProductProfitsTwo.setIsDelete((byte) 0);
//            dealerProductProfitsTwo.setIsAvailable((byte) 1);
//            dealerProductProfitsTwo.setCompanyId(cas1RelationForDealer.getId());
//            getChannelRole(dealerProductProfitsTwo, business);
//            dealerProductProfitsTwo.setDealerProductId(cas1RelationForDealerProduct.getId());
//            dealerProductProfitsTwo.setLoanPeriod("24");
//            dealerProductProfitsTwo.setPrice(new BigDecimal(dealerProductProfitsForCas1.getTwoPrice()));
//            dealerProductProfitsTwo.setProfit(new BigDecimal(dealerProductProfitsForCas1.getTwoProfit()));
//
//            DealerProductProfits dealerProductProfitsThree = new DealerProductProfits();
//            dealerProductProfitsThree.setId(IdGenerater.uuid());
//            dealerProductProfitsThree.setCreatedBy("脚本导入");
//            dealerProductProfitsThree.setCreatedOn(new Date());
//            dealerProductProfitsThree.setIsDelete((byte) 0);
//            dealerProductProfitsThree.setIsAvailable((byte) 1);
//            dealerProductProfitsThree.setCompanyId(cas1RelationForDealer.getId());
//
//            getChannelRole(dealerProductProfitsThree, business);
//            dealerProductProfitsThree.setDealerProductId(cas1RelationForDealerProduct.getId());
//            dealerProductProfitsThree.setLoanPeriod("12");
//            dealerProductProfitsThree.setPrice(new BigDecimal(dealerProductProfitsForCas1.getThreePrice()));
//            dealerProductProfitsThree.setProfit(new BigDecimal(dealerProductProfitsForCas1.getThreeProfit()));
//            dealerProductProfitsList.add(dealerProductProfitsOne);
//            dealerProductProfitsList.add(dealerProductProfitsTwo);
//            dealerProductProfitsList.add(dealerProductProfitsThree);
//        }
//
//        for (DealerProductProfits dealerProductProfits : dealerProductProfitsList) {
//            dealerProductProfitsMapper.insert(dealerProductProfits);
//        }
//
//    }
//
//    @Test
//    public void importDealerDocument() throws IOException{
//        DatabaseContextHolder.setDatabaseType(DatabaseType.mytestdb);
//        List<FirmDealers> firmDealersList = firmDealersMapper.selectDealer();
//        List<DealerAllocation> list = new ArrayList<>();
//        for (FirmDealers firmDealers : firmDealersList) {
//            DatabaseContextHolder.setDatabaseType(DatabaseType.mytestdb);
//            FirmDocuments firmDocuments = firmDocumentsMapper.selectByPrimaryKey(firmDealers.getDocumentId());
//            FirmDealers mortgage = firmDealersMapper.selectByPrimaryKey(firmDealers.getpId());
//            DatabaseContextHolder.setDatabaseType(DatabaseType.mytestdb2);
//            SysCompany documentCompany = sysCompanyMapper.selectByName(firmDocuments.getName());
//            SysCompany mortgageCompany = sysCompanyMapper.selectByName(mortgage.getName());
//            SysCompany sysCompany = sysCompanyMapper.selectByName(firmDealers.getName());
//            if(sysCompany == null || documentCompany == null || mortgageCompany == null ){
//                continue;
//            }
//            DealerAllocation dealerAllocation = new DealerAllocation();
//            dealerAllocation.setId(IdGenerater.uuid());
//            dealerAllocation.setDealerId(sysCompany.getId());
//            dealerAllocation.setCompanyName(sysCompany.getName());
//            dealerAllocation.setCebDocument(documentCompany.getId());
//            dealerAllocation.setShjzDocument(documentCompany.getId());
//            dealerAllocation.setCebMortgage(mortgageCompany.getId());
//            dealerAllocation.setShjzMortgage(mortgageCompany.getId());
//            dealerAllocationMapper.insert(dealerAllocation);
//
//        }
//
//
//    }
//
//    private void getChannelRole(DealerProductProfits dealerProductProfitsThree, Byte business) {
//        if(1 == business){
//            dealerProductProfitsThree.setChannelRole("dealer");
//        }else if(0 == business){
//            dealerProductProfitsThree.setChannelRole("sp");
//        }else{
//            dealerProductProfitsThree.setChannelRole("acp");
//        }
//    }
//
//    private void getChannelRole(DealerProductProfits dealerProductProfitsThree, Integer business) {
//            if(1 == business){
//                dealerProductProfitsThree.setChannelRole("dealer");
//            }else if(0 == business){
//                dealerProductProfitsThree.setChannelRole("sp");
//            }else if(2 == business){
//                dealerProductProfitsThree.setChannelRole("acp");
//            }else{
//                dealerProductProfitsThree.setChannelRole("");
//            }
//        }
//
//    public String saveCustomerStaff(SysUser user) throws IOException {
//        String saveUrl ="http://10.135.22.9:8080/customer/staff/save";
//        CustomerStaff customerStaff = new CustomerStaff();
//        customerStaff.setCustomerId(user.getCompany().getCoreCustomerId());
//        customerStaff.setCustomerName(user.getCompany().getName());
//        customerStaff.setLoginName(user.getLoginName());
//        customerStaff.setPassword(user.getPassword());
//        customerStaff.setStaffName(user.getRealName());
//        customerStaff.setContactMobile(user.getMobile());
//        customerStaff.setEmail(user.getEmail());
//        if(user.getBirth() != null){
//            customerStaff.setBirth(user.getBirth().getTime());
//        }
//        customerStaff.setProvince(user.getProvince());
//        customerStaff.setCity(user.getCity());
//        customerStaff.setDistrict(user.getDistrict());
//        customerStaff.setAddress(user.getAddress());
//        customerStaff.setAvatar(user.getAvatar());
//        customerStaff.setGender(Integer.toString(user.getGender()));
//        customerStaff.setCreateBy(user.getCreatedBy());
//        String post = HttpUtil.post(saveUrl, JSONObject.toJSONString(customerStaff), HttpUtil.CONTENT_TYPE_JSON);
//        System.out.println(post);
//        ResponseData result = JSON.parseObject(post, ResponseData.class);
//        if (BaseResContents.KEY_SUCCESS.equals(result.getCode())) {
//            return (String) result.getData().get("id");
//        } else {
//            System.out.println( JSONObject.toJSONString(customerStaff));
//            throw new RuntimeException("推送核心数据库用户信息失败");
//        }
//    }
//
//    public String saveCustommer(SysCompany company) throws IOException {
//        String custommerUrl = "http://10.135.22.9:8080/customer/save";
//        Map<String, Object> custommerMap = new HashMap<String, Object>();
//        custommerMap.put("customerType", "company");
//        custommerMap.put("contactMan", company.getLinkman());
//        custommerMap.put("contactMobile", company.getPhone());
//        custommerMap.put("customerName", company.getName());
//        custommerMap.put("shortName", company.getName());
//        custommerMap.put("province", company.getProvince());
//        custommerMap.put("city", company.getCity());
//        custommerMap.put("district", company.getDistrict());
//        custommerMap.put("customerAddress", company.getAddress());
//        custommerMap.put("enterprise", company.getCreditCode());
//        custommerMap.put("createBy", company.getCreatedBy());
//        System.out.println("参数："+ JSON.toJSONString(custommerMap));
//        String jsonResult = HttpUtil.post(custommerUrl, custommerMap);
//        System.out.println(jsonResult);
//        ResponseData result = JSON.parseObject(jsonResult, ResponseData.class);
//        String id = "";
//        if (BaseResContents.KEY_SUCCESS.equals(result.getCode())) {
//
//            Object idObj = result.getData().get("id");
//            if (idObj != null && idObj instanceof String) {
//                id = (String) idObj;
//            }
//        } else {
//            System.out.println(result);
//            throw new RuntimeException("推送核心数据库--公司数据失败");
//        }
//
//        return id;
//    }

}
