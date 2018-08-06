package com.lzf;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.lzf.dao.*;
import com.lzf.entity.*;
import com.lzf.utils.BeanUtils;
import com.lzf.utils.CryptoUtils;
import com.lzf.utils.IdGenerater;
import com.lzf.utils.PinYinUtils;
import org.apache.commons.lang3.StringUtils;
import org.junit.BeforeClass;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.MethodSorters;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.util.CollectionUtils;

import java.io.IOException;
import java.math.BigDecimal;
import java.util.*;

/**
 * 描述:
 * 测试mybatisDAO
 *
 * @author liuzhenfei
 * @create 2017-09-20 上午 10:19
 */
@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT, classes = MybatisAppaction.class)
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class TestDao {

    private static String stage = "stage";

    private static String online = "online";

    private static String noCheck = "0";

    private static String check = "1";

    private static Map<String, String> roleRelation = new HashMap<>();

    private static List<SysCompany> list = new ArrayList<>();

    private static List<SysUser> userList = new ArrayList<>();

    private static List<Cas1Relation> cas1RelationList = new ArrayList<>();

    private static Map<String,SysCompany> sysCompanyMap = new HashMap<>();


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
    private SysRoleUserRelForCas2Mapper sysRoleUserRelForCas2Mapper;

    @Autowired
    private SysRoleUserRelMapper sysRoleUserRelMapper;

    @Autowired
    private CustomerMapper customerMapper;

    @Autowired
    private CustomerStaffMapper customerStaffMapper;

    @Autowired
    private CustomerStaffAccountMapper customerStaffAccountMapper;



    @BeforeClass
    public static void initRoleRelation(){

        //经销商-金融专员
        roleRelation.put("43","a10176e7073f17a1e8d50f8fd32562d0");
        //经销商-管理员
//        roleRelation.put("45","");
        //acp/sp抵押办理员
        roleRelation.put("19","4b6e1adc85571d3dd99f54730663b7fb");
        /****************************************************************/
        //PBOC审核专员
        roleRelation.put("6","71f331250215d8930e6f60c0d213e2e7");
        //资质初审
        roleRelation.put("12","0004a975452cb0e67474733bc37f7330");
        //资质复审
        roleRelation.put("16","d93fbd09a22a06097f0c9adc40fc16a7");
        //资质高级审批
        roleRelation.put("17","20d2e997e689865f4e8b71bb61439175");
        /****************************************************************/
        //保险初审
        roleRelation.put("23","45131b42a20c225aa308b2b9f464e7c0");
        //人保二审
        roleRelation.put("26","9e0f372e6722222ae47b556abfd63424");
        //人保上传承保意向书
        roleRelation.put("15","d8ac7631ace34a5c914b4922e9d08eb9");
        //资质复审
        roleRelation.put("13","9b049272d50095470123a4cf5a0942b9");
        //抵押材料确认
//        roleRelation.put("","be050b1d253ec8c527d889ea461c215c");
        //人保-管理员
        roleRelation.put("24","be050b1d253ec8c527d889ea461c215c,9b049272d50095470123a4cf5a0942b9," +
                "d8ac7631ace34a5c914b4922e9d08eb9,9e0f372e6722222ae47b556abfd63424,45131b42a20c225aa308b2b9f464e7c0");
        /****************************************************************/
        //放款审批一审
        roleRelation.put("27","4ae7a1c2d113ffe30b1abe27eda0b124");
        //放款审批二审
        roleRelation.put("31","423875ff93dfb672f984d199d07d7109");
        /****************************************************************/
        //财务初审员
        roleRelation.put("125","cc1a516fc38ab753409cd5fd4562bc7f");
        //财务复审员
        roleRelation.put("124","8a705109a9ebd7e340eba2c4e4806615");
        //银行垫资审核-上传回执单
        roleRelation.put("123","f3096148c5e18696646f1b1542131501");
        /****************************************************************/
        //资方待同意签约
//        roleRelation.put("","aad0338053c3be97531c9c30706a5359");
        //资方待同意放款
//        roleRelation.put("","c3c8158d826d31ba5e3ffa541031c5ee");
        //资方确认放款
//        roleRelation.put("","2e2639c6a7ac2f38277accff2883cb69");
        //资方确认放款完成
//        roleRelation.put("","3ccd929364ad06b1384bc399c11b3cc1");
        //石化金租待放款
        roleRelation.put("126","1de1826e75f3f9962fb54832e5365123");
        /****************************************************************/
        //单证总公司归档员
        roleRelation.put("87","7b46dd1ee2327e166072ff6ffa5f9242");
        //终端单证业务员
        roleRelation.put("38","5d378e5111373bce36acc73601bad80e");
        //现章合同快递员
//        roleRelation.put("","e8048303f5d446fb3b843b067dc3b6db");
        //人保快递员
        roleRelation.put("21","ca3b9429b884148c48318b32303f98c0");
        /****************************************************************/
        //单证审核员
        roleRelation.put("41","ff2e7f77a7a0d72a47f4784234fca61c");
        /****************************************************************/
        //鲁诺家访管理员
        roleRelation.put("48","4446da3e88c7ce524aca002908359b3b");
        //订单异常处理
//        roleRelation.put("","2be9a6473cc7cd8ae7d55ca10eafcf83");
        //家访员
        roleRelation.put("71","7162699e8d5c11ffa19e8529f9897404");
        //家访公司管理员
        roleRelation.put("47","490e14e6a5814e260d66dff2219e951b");

    }

    @Test
    public void testAAACheckLoginName() throws IOException {
        System.out.println("213 === "+roleRelation.size());
        DatabaseContextHolder.setDatabaseType(DatabaseType.mytestdb);
        List<SysUsers> usersList = sysUsersMapper.selectAll();
        DatabaseContextHolder.setDatabaseType(DatabaseType.mytestdb3);
        for (SysUsers sysUsers : usersList) {
            String loginName = sysUsers.getUsername();
            System.out.println(loginName);
            CustomerStaffAccount customerStaffAccount = customerStaffAccountMapper.findByLoginName(loginName);
            if(customerStaffAccount != null){
                System.out.println("登录名重复："+JSON.toJSONString(customerStaffAccount));
            }

        }
    }

    @Test
    public void testBBBFinances() throws Exception {
        clearCollections();
        DatabaseContextHolder.setDatabaseType(DatabaseType.mytestdb);
        List<FirmFinances> firmFinances = firmFinancesMapper.selectAll();
        List<BizFinancial> bizFinancialArrayList = new ArrayList<>();
        for (FirmFinances firmFinance : firmFinances) {
            //填充公司信息
            SysCompany sysCompany = initSysCompany();
            sysCompany.setName(firmFinance.getName());
            String pinYinHeadChar = PinYinUtils.getPinYinHeadChar(firmFinance.getName());
            if (StringUtils.isBlank(pinYinHeadChar)) {
                pinYinHeadChar = IdGenerater.RandomLowerCharater(4);
            }
            sysCompany.setCode(pinYinHeadChar);
            sysCompany.setPhone(firmFinance.getMobile());
            sysCompany.setLinkman(firmFinance.getLinkman());
            sysCompany.setAddress(firmFinance.getAddress());
            sysCompany.setProvince(firmFinance.getProvince());
            sysCompany.setCity(firmFinance.getCity());
            sysCompany.setDistrict(firmFinance.getDistrict());
            list.add(sysCompany);
            sysCompanyMap.put("Finance"+firmFinance.getId(),sysCompany);

            //填充金融公司信息
            BizFinancial bizFinancial = new BizFinancial();
            bizFinancial.setId(IdGenerater.uuid());
            bizFinancial.setCreatedBy("脚本导入");
            bizFinancial.setCreatedOn(new Date());
            bizFinancial.setIsDelete(false);
            bizFinancial.setIsAvailable(true);
            bizFinancial.setCompanyId(sysCompany.getId());
            bizFinancial.setCompany(sysCompany);
            bizFinancial.setStatus(check);
            bizFinancial.setDataType(stage);
            bizFinancialArrayList.add(bizFinancial);

            //CAS1与CAS2关系
            Cas1Relation cas1Relation = new Cas1Relation();
            cas1Relation.setId(sysCompany.getId());
            cas1Relation.setType("Finance");
            cas1Relation.setCas1Id(firmFinance.getId() + "");
            cas1RelationList.add(cas1Relation);



        }

        //填充用户信息
        SysUsers params = new SysUsers();
        params.setFirmType("Finance");
        List<SysUsers> usersList = sysUsersMapper.findByParams(params);
        if (!CollectionUtils.isEmpty(usersList)) {
            for (SysUsers sysUsers : usersList) {
                SysCompany sysCompany = sysCompanyMap.get("Finance" + sysUsers.getFirmId());
                addUserAndRelation(userList, cas1RelationList, sysUsers, sysCompany);
            }
        }


        insertCompany(list);

        insertFinancial(bizFinancialArrayList);

        insertCas1Relation(cas1RelationList);

        insertUser(userList);

    }

    @Test
    public void testCCCCapitals() throws Exception {
        clearCollections();
        DatabaseContextHolder.setDatabaseType(DatabaseType.mytestdb);
        List<FirmCapitals> firmFinances = firmCapitalsMapper.selectAll();
        List<BizCapital> bizCapitalList = new ArrayList<>();

        for (FirmCapitals firmCapitals : firmFinances) {
            SysCompany sysCompany = null;
            if (sysCompany == null) {
                sysCompany = initSysCompany();
                sysCompany.setName(firmCapitals.getName());
                String pinYinHeadChar = PinYinUtils.getPinYinHeadChar(firmCapitals.getName());
                if (StringUtils.isBlank(pinYinHeadChar)) {
                    pinYinHeadChar = IdGenerater.RandomLowerCharater(4);
                }
                sysCompany.setCode(pinYinHeadChar);
                sysCompany.setPhone(firmCapitals.getLoanPhone());
                sysCompany.setLinkman(firmCapitals.getLinkman());
                sysCompany.setAddress(firmCapitals.getAddress());
                sysCompany.setProvince(firmCapitals.getProvince());
                sysCompany.setCity(firmCapitals.getCity());
                sysCompany.setDistrict(firmCapitals.getDistrict());
                sysCompany.setCanCapital(true);
                list.add(sysCompany);
            }
            sysCompanyMap.put("Capital"+firmCapitals.getId(),sysCompany);


            BizCapital bizCapital = new BizCapital();
            bizCapital.setId(IdGenerater.uuid());
            bizCapital.setCreatedBy("脚本导入");
            bizCapital.setCreatedOn(new Date());
            bizCapital.setIsDelete(false);
            bizCapital.setIsAvailable(true);
            bizCapital.setIsNeedAppointment(true);
            bizCapital.setAllowPrivateAccount(firmCapitals.getSupportprivate());
            bizCapital.setCompanyId(sysCompany.getId());
            bizCapital.setCompany(sysCompany);
            bizCapital.setFirstBeneficiary(firmCapitals.getFirstBeneficiary());
            //单证流程
            bizCapital.setTransferKey("transfer_ccb_ceb");
            //还款卡类型默认为借记卡
            bizCapital.setCardType("1");
            //日期规则默认为石化金租
            bizCapital.setOrderDateProvider("tpshOrderDateProvider");
            bizCapital.setDataType(stage);
            bizCapital.setStatus(check);
            bizCapitalList.add(bizCapital);

            Cas1Relation cas1Relation = new Cas1Relation();
            cas1Relation.setId(sysCompany.getId());
            cas1Relation.setType("Capital");
            cas1Relation.setCas1Id(firmCapitals.getId() + "");
            cas1RelationList.add(cas1Relation);



        }

        SysUsers params = new SysUsers();
        params.setFirmType("Capital");
        DatabaseContextHolder.setDatabaseType(DatabaseType.mytestdb);
        List<SysUsers> usersList = sysUsersMapper.findByParams(params);

        if (!CollectionUtils.isEmpty(usersList)) {
            DatabaseContextHolder.setDatabaseType(DatabaseType.mytestdb2);
            for (SysUsers sysUsers : usersList) {
                SysCompany sysCompany = sysCompanyMap.get("Capital" + sysUsers.getFirmId());
                addUserAndRelation(userList, cas1RelationList, sysUsers, sysCompany);

            }
        }

        insertCompany(list);

        insertCas1Relation(cas1RelationList);

        insertUser(userList);

        insertCapital(bizCapitalList);
    }

    @Test
    public void testDDDDocuments() throws Exception {
        clearCollections();
        DatabaseContextHolder.setDatabaseType(DatabaseType.mytestdb);
        List<FirmDocuments> firmDocumentsList = firmDocumentsMapper.selectAll();
        List<BizDocument> bizDocumentList = new ArrayList<>();
        for (FirmDocuments firmDocuments : firmDocumentsList) {
            SysCompany sysCompany = null;
            if (sysCompany == null) {
                sysCompany = initSysCompany();
                sysCompany.setName(firmDocuments.getName());
                String pinYinHeadChar = PinYinUtils.getPinYinHeadChar(firmDocuments.getName());
                if (StringUtils.isBlank(pinYinHeadChar)) {
                    pinYinHeadChar = IdGenerater.RandomLowerCharater(4);
                }
                sysCompany.setCode(pinYinHeadChar);
                sysCompany.setPhone(firmDocuments.getMobile());
                sysCompany.setLinkman(firmDocuments.getLinkman());
                sysCompany.setAddress(firmDocuments.getAddress());
                sysCompany.setProvince(firmDocuments.getProvince());
                sysCompany.setCity(firmDocuments.getCity());
                sysCompany.setDistrict(firmDocuments.getDistrict());
                sysCompany.setCanDocument(true);
                list.add(sysCompany);
            }
            sysCompanyMap.put("Document"+firmDocuments.getId(),sysCompany);

            BizDocument bizDocument = new BizDocument();
            if ("全国总公司".equals(firmDocuments.getName())) {
                bizDocument.setId("1234567890");
                bizDocument.setParentId(null);
                bizDocument.setType("0");
            } else {
                bizDocument.setId(IdGenerater.uuid());
                bizDocument.setParentId("1234567890");
                bizDocument.setType("1");
            }
            bizDocument.setCreatedBy("脚本导入");
            bizDocument.setCreatedOn(new Date());
            bizDocument.setIsDelete(false);
            bizDocument.setIsAvailable(true);
            bizDocument.setDataType(stage);
            bizDocument.setStatus(check);
            bizDocument.setCompanyId(sysCompany.getId());
            bizDocument.setCompany(sysCompany);
            bizDocumentList.add(bizDocument);

            Cas1Relation cas1Relation = new Cas1Relation();
            cas1Relation.setId(sysCompany.getId());
            cas1Relation.setType("Document");
            cas1Relation.setCas1Id(firmDocuments.getId() + "");
            cas1RelationList.add(cas1Relation);


        }

        SysUsers params = new SysUsers();
        params.setFirmType("Document");
        DatabaseContextHolder.setDatabaseType(DatabaseType.mytestdb);
        List<SysUsers> usersList = sysUsersMapper.findByParams(params);
        if (!CollectionUtils.isEmpty(usersList)) {
            for (SysUsers sysUsers : usersList) {
                SysCompany sysCompany = sysCompanyMap.get("Document" + sysUsers.getFirmId());
                addUserAndRelation(userList,cas1RelationList, sysUsers, sysCompany);
            }

        }



        insertCompany(list);

        insertCas1Relation(cas1RelationList);

        insertUser(userList);

        insertDocument(bizDocumentList);

    }

    @Test
    public void testEEEHomeVisits() throws Exception {
        clearCollections();
        DatabaseContextHolder.setDatabaseType(DatabaseType.mytestdb);
        List<FirmHomeVisits> firmHomeVisitsList = firmHomeVisitsMapper.selectAll();
        List<BizVisit> bizVisitList = new ArrayList<>();
        for (FirmHomeVisits firmHomeVisits : firmHomeVisitsList) {

            SysCompany sysCompany = null;
            if (sysCompany == null) {
                sysCompany = initSysCompany();
                sysCompany.setName(firmHomeVisits.getName());
                String pinYinHeadChar = PinYinUtils.getPinYinHeadChar(firmHomeVisits.getName());
                if (StringUtils.isBlank(pinYinHeadChar)) {
                    pinYinHeadChar = IdGenerater.RandomLowerCharater(4);
                }
                sysCompany.setCode(pinYinHeadChar);
                sysCompany.setPhone(firmHomeVisits.getMobile());
                sysCompany.setLinkman(firmHomeVisits.getContactMan());
                sysCompany.setAddress(firmHomeVisits.getAddress());
                sysCompany.setProvince(firmHomeVisits.getProvince());
                sysCompany.setCity(firmHomeVisits.getCity());
                sysCompany.setDistrict(firmHomeVisits.getDistrict());

                list.add(sysCompany);
            }

            sysCompanyMap.put("HomeVisit"+firmHomeVisits.getId(),sysCompany);

            BizVisit bizVisit = new BizVisit();
            bizVisit.setId(IdGenerater.uuid());
            bizVisit.setCreatedBy("脚本导入");
            bizVisit.setCreatedOn(new Date());
            bizVisit.setIsDelete(false);
            bizVisit.setIsAvailable(true);
            bizVisit.setCompanyId(sysCompany.getId());
            bizVisit.setCompany(sysCompany);
            bizVisit.setStatus(check);
            bizVisit.setDataType(stage);
            bizVisitList.add(bizVisit);

            Cas1Relation cas1Relation = new Cas1Relation();
            cas1Relation.setId(sysCompany.getId());
            cas1Relation.setType("HomeVisit");
            cas1Relation.setCas1Id(firmHomeVisits.getId() + "");
            cas1RelationList.add(cas1Relation);

        }

        SysUsers params = new SysUsers();
        params.setFirmType("HomeVisit");
        DatabaseContextHolder.setDatabaseType(DatabaseType.mytestdb);
        List<SysUsers> usersList = sysUsersMapper.findByParams(params);
        if (!CollectionUtils.isEmpty(usersList)) {
            DatabaseContextHolder.setDatabaseType(DatabaseType.mytestdb2);
            for (SysUsers sysUsers : usersList) {
                SysCompany sysCompany = sysCompanyMap.get("HomeVisit" + sysUsers.getFirmId());
                addUserAndRelation(userList, cas1RelationList,sysUsers,sysCompany);
            }
        }

        insertCompany(list);

        insertVisit(bizVisitList);

        insertCas1Relation(cas1RelationList);

        insertUser(userList);

    }

    @Test
    public void testFFFInsures() throws Exception {
        clearCollections();
        DatabaseContextHolder.setDatabaseType(DatabaseType.mytestdb);
        List<FirmInsures> firmInsuresList = firmInsuresMapper.selectAll();
        for (FirmInsures firmInsures : firmInsuresList) {

            SysCompany sysCompany = null;
            if (sysCompany == null) {
                sysCompany =initSysCompany();
                sysCompany.setName(firmInsures.getName());
                String pinYinHeadChar = PinYinUtils.getPinYinHeadChar(firmInsures.getName());
                if (StringUtils.isBlank(pinYinHeadChar)) {
                    pinYinHeadChar = IdGenerater.RandomLowerCharater(4);
                }
                sysCompany.setCode(pinYinHeadChar);
                sysCompany.setPhone(firmInsures.getMobile());
                sysCompany.setLinkman(firmInsures.getLinkman());
                sysCompany.setAddress(firmInsures.getAddress());
                sysCompany.setProvince(firmInsures.getProvince());
                sysCompany.setCity(firmInsures.getCity());
                sysCompany.setDistrict(firmInsures.getDistrict());

                list.add(sysCompany);
            }

            sysCompanyMap.put("Insure"+firmInsures.getId(),sysCompany);

            Cas1Relation cas1Relation = new Cas1Relation();
            cas1Relation.setId(sysCompany.getId());
            cas1Relation.setType("Insure");
            cas1Relation.setCas1Id(firmInsures.getId() + "");
            cas1RelationList.add(cas1Relation);

        }

        SysUsers params = new SysUsers();
        params.setFirmType("Insure");
        DatabaseContextHolder.setDatabaseType(DatabaseType.mytestdb);
        List<SysUsers> usersList = sysUsersMapper.findByParams(params);
        if (!CollectionUtils.isEmpty(usersList)) {
            DatabaseContextHolder.setDatabaseType(DatabaseType.mytestdb2);
            for (SysUsers sysUsers : usersList) {
                SysCompany sysCompany = sysCompanyMap.get("Insure" + sysUsers.getFirmId());
                addUserAndRelation(userList,cas1RelationList,sysUsers,sysCompany);
            }

        }

        DatabaseContextHolder.setDatabaseType(DatabaseType.mytestdb2);

        insertCompany(list);

        insertCas1Relation(cas1RelationList);

        insertUser(userList);

    }

    @Test
    public void testGGGACP() throws Exception {
        clearCollections();
        DatabaseContextHolder.setDatabaseType(DatabaseType.mytestdb);
        List<FirmDealers> firmDealersList = firmDealersMapper.selectACP();
        List<BizChannel> bizChannelList = new ArrayList<>();
        for (FirmDealers firmDealers : firmDealersList) {

            DatabaseContextHolder.setDatabaseType(DatabaseType.mytestdb2);
            SysCompany sysCompany = null;
            if (sysCompany == null) {
                sysCompany = initSysCompany();
                String pinYinHeadChar = PinYinUtils.getPinYinHeadChar(firmDealers.getName());
                if (StringUtils.isBlank(pinYinHeadChar)) {
                    pinYinHeadChar = IdGenerater.RandomLowerCharater(4);
                }
                sysCompany.setCode(pinYinHeadChar);
                sysCompany.setName(firmDealers.getName());
                sysCompany.setPhone(firmDealers.getMobile());
                sysCompany.setLinkman(firmDealers.getLinkman());
                sysCompany.setAddress(firmDealers.getAddress());
                sysCompany.setProvince(firmDealers.getProvince());
                sysCompany.setCity(firmDealers.getCity());
                sysCompany.setDistrict(firmDealers.getDistrict());
                sysCompany.setCreditCode(firmDealers.getEnterpriseCode());//营业执照编号
                sysCompany.setCanAcp(true);
                list.add(sysCompany);
            }

            sysCompanyMap.put("Dealer"+firmDealers.getId(),sysCompany);

            Cas1Relation cas1Relation = new Cas1Relation();
            cas1Relation.setId(sysCompany.getId());
            cas1Relation.setType("Dealer");
            cas1Relation.setCas1Id(firmDealers.getId() + "");
            cas1RelationList.add(cas1Relation);


            BizChannel bizChannel = new BizChannel();
            bizChannel.setId(firmDealers.getId()+"");
            bizChannel.setCreatedBy("脚本导入");
            bizChannel.setCreatedOn(new Date());
            bizChannel.setIsDelete((byte) 0);
            bizChannel.setIsAvailable((byte) 1);
            bizChannel.setCompanyId(sysCompany.getId());
            bizChannel.setCompany(sysCompany);
            bizChannel.setChannelRole("acp");
            bizChannel.setParentId(null);
            bizChannel.setStatus(check);
            bizChannel.setDataType(stage);
            bizChannel.setTrustAccountNo(firmDealers.getTrusteeshipCard());
            bizChannel.setReciveAccountNo(firmDealers.getCollectionCard());
            bizChannel.setReciveAccountBank(firmDealers.getCollectionCardBank());
            bizChannelList.add(bizChannel);



        }

        DatabaseContextHolder.setDatabaseType(DatabaseType.mytestdb);
        SysUsers params = new SysUsers();
        params.setFirmType("Dealer");
        List<SysUsers> usersList = sysUsersMapper.findByParams(params);
        if (!CollectionUtils.isEmpty(usersList)) {
            for (SysUsers sysUsers : usersList) {
                SysCompany sysCompany = sysCompanyMap.get("Dealer" + sysUsers.getFirmId());
                addUserAndRelation(userList,cas1RelationList,sysUsers,sysCompany);
            }

        }



        insertCompany(list);

        insertChannel(bizChannelList);

        insertCas1Relation(cas1RelationList);


        insertUser(userList);



    }

    @Test
    public void testHHHSP() throws Exception {
        clearCollections();
        DatabaseContextHolder.setDatabaseType(DatabaseType.mytestdb);
        List<FirmDealers> firmDealersList = firmDealersMapper.selectSP();

        List<BizChannel> bizChannelList = new ArrayList<>();
        for (FirmDealers firmDealers : firmDealersList) {


            DatabaseContextHolder.setDatabaseType(DatabaseType.mytestdb2);
            SysCompany sysCompany = null;
            if (sysCompany == null) {
                sysCompany = initSysCompany();
                sysCompany.setName(firmDealers.getName());
                String pinYinHeadChar = PinYinUtils.getPinYinHeadChar(firmDealers.getName());
                if (StringUtils.isBlank(pinYinHeadChar)) {
                    pinYinHeadChar = IdGenerater.RandomLowerCharater(4);
                }
                sysCompany.setCode(pinYinHeadChar);
                sysCompany.setPhone(firmDealers.getMobile());
                sysCompany.setLinkman(firmDealers.getLinkman());
                sysCompany.setAddress(firmDealers.getAddress());
                sysCompany.setProvince(firmDealers.getProvince());
                sysCompany.setCity(firmDealers.getCity());
                sysCompany.setDistrict(firmDealers.getDistrict());
                sysCompany.setCreditCode(firmDealers.getEnterpriseCode());//营业执照编号
                sysCompany.setCanSp(true);
                list.add(sysCompany);
            }
            sysCompanyMap.put("Dealer"+firmDealers.getId(),sysCompany);

            Cas1Relation cas1Relation = new Cas1Relation();
            cas1Relation.setId(sysCompany.getId());
            cas1Relation.setType("Dealer");
            cas1Relation.setCas1Id(firmDealers.getId() + "");
            cas1RelationList.add(cas1Relation);


            BizChannel bizChannel = new BizChannel();
            bizChannel.setId(firmDealers.getId()+"");
            bizChannel.setCreatedBy("脚本导入");
            bizChannel.setCreatedOn(new Date());
            bizChannel.setIsDelete((byte) 0);
            bizChannel.setIsAvailable((byte) 1);
            bizChannel.setCompanyId(sysCompany.getId());
            bizChannel.setCompany(sysCompany);
            bizChannel.setChannelRole("sp");
            bizChannel.setStatus(check);
            bizChannel.setDataType(stage);
            if (firmDealers.getIsGood() != null && firmDealers.getIsGood() == 1) {
                bizChannel.setQualityDealer(true);
            } else {
                bizChannel.setQualityDealer(false);
            }
            bizChannel.setParentId(firmDealers.getpId()+"");

            bizChannel.setTrustAccountNo(firmDealers.getTrusteeshipCard());
            bizChannel.setReciveAccountNo(firmDealers.getCollectionCard());
            bizChannel.setReciveAccountBank(firmDealers.getCollectionCardBank());
            bizChannelList.add(bizChannel);




        }

        DatabaseContextHolder.setDatabaseType(DatabaseType.mytestdb);
        SysUsers params = new SysUsers();
        params.setFirmType("Dealer");
        List<SysUsers> usersList = sysUsersMapper.findByParams(params);
        if (!CollectionUtils.isEmpty(usersList)) {
            for (SysUsers sysUsers : usersList) {
                SysCompany sysCompany = sysCompanyMap.get("Dealer" + sysUsers.getFirmId());
                addUserAndRelation(userList,cas1RelationList,sysUsers,sysCompany);
            }

        }



        insertCompany(list);

        insertChannel(bizChannelList);

        insertCas1Relation(cas1RelationList);

        insertUser(userList);

    }

    @Test
    public void testIIIDealer() throws Exception {
        clearCollections();
        DatabaseContextHolder.setDatabaseType(DatabaseType.mytestdb);
        List<FirmDealers> firmDealersList = firmDealersMapper.selectDealer();
        List<BizChannel> bizChannelList = new ArrayList<>();
        for (FirmDealers firmDealers : firmDealersList) {


            DatabaseContextHolder.setDatabaseType(DatabaseType.mytestdb2);
            SysCompany sysCompany = null;
            if (sysCompany == null) {
                sysCompany = initSysCompany();
                sysCompany.setName(firmDealers.getName());
                String pinYinHeadChar = PinYinUtils.getPinYinHeadChar(firmDealers.getName());
                if (StringUtils.isBlank(pinYinHeadChar)) {
                    pinYinHeadChar = IdGenerater.RandomLowerCharater(4);
                }
                sysCompany.setCode(pinYinHeadChar);
                sysCompany.setPhone(firmDealers.getMobile());
                sysCompany.setLinkman(firmDealers.getLinkman());
                sysCompany.setAddress(firmDealers.getAddress());
                sysCompany.setProvince(firmDealers.getProvince());
                sysCompany.setCity(firmDealers.getCity());
                sysCompany.setDistrict(firmDealers.getDistrict());
                sysCompany.setCreditCode(firmDealers.getEnterpriseCode());//营业执照编号
                sysCompany.setCanDealer(true);
                if (firmDealers.getIsGood() != null && firmDealers.getIsGood() == 1) {
                    sysCompany.setIsQualityDealer(true);
                } else {
                    sysCompany.setIsQualityDealer(false);
                }
                list.add(sysCompany);
            }

            sysCompanyMap.put("Dealer"+firmDealers.getId(),sysCompany);

            Cas1Relation cas1Relation = new Cas1Relation();
            cas1Relation.setId(sysCompany.getId());
            cas1Relation.setType("Dealer");
            cas1Relation.setCas1Id(firmDealers.getId() + "");
            cas1RelationList.add(cas1Relation);

            BizChannel bizChannel = new BizChannel();
            bizChannel.setId(IdGenerater.uuid());
            bizChannel.setCreatedBy("脚本导入");
            bizChannel.setCreatedOn(new Date());
            bizChannel.setIsDelete((byte) 0);
            bizChannel.setIsAvailable((byte) 1);
            bizChannel.setCompanyId(sysCompany.getId());
            bizChannel.setCompany(sysCompany);
            bizChannel.setChannelRole("dealer");
            DatabaseContextHolder.setDatabaseType(DatabaseType.mytestdb2);
            Integer pId = firmDealers.getpId();
            bizChannel.setParentId(pId+"");
            bizChannel.setTrustAccountNo(firmDealers.getTrusteeshipCard());
            bizChannel.setReciveAccountNo(firmDealers.getCollectionCard());
            bizChannel.setReciveAccountBank(firmDealers.getCollectionCardBank());
            bizChannelList.add(bizChannel);
            if (firmDealers.getIsGood() != null && firmDealers.getIsGood() == 1) {
                bizChannel.setQualityDealer(true);
            } else {
                bizChannel.setQualityDealer(false);
            }



        }

        DatabaseContextHolder.setDatabaseType(DatabaseType.mytestdb);
        SysUsers params = new SysUsers();
        params.setFirmType("Dealer");
        List<SysUsers> usersList = sysUsersMapper.findByParams(params);
        if (!CollectionUtils.isEmpty(usersList)) {
            for (SysUsers sysUsers : usersList) {
                SysCompany sysCompany = sysCompanyMap.get("Dealer" + sysUsers.getFirmId());
                addUserAndRelation(userList,cas1RelationList,sysUsers,sysCompany);

            }

        }



        insertCompany(list);

        insertChannel(bizChannelList);

        insertCas1Relation(cas1RelationList);


        insertUser(userList);


    }

    @Test
    public void testJJJRoleUser() throws Exception {
        clearCollections();
        System.out.println( "大1111："+JSON.toJSONString(roleRelation) );
        DatabaseContextHolder.setDatabaseType(DatabaseType.mytestdb2);
        List<Cas1Relation> userRelationList = cas1RelationMapper.findByType("User");
        System.out.println( "大小123："+userRelationList.size() );
        List<SysRoleUserRelForCas2> sysRoleUserRelForCas2s = new ArrayList<>();
        DatabaseContextHolder.setDatabaseType(DatabaseType.mytestdb);
        for (Cas1Relation cas1Relation : userRelationList) {
            List<SysRoleUserRel> cas1List = sysRoleUserRelMapper.selectByUserId(cas1Relation.getCas1Id());
            System.out.println( "大小："+ JSON.toJSONString(cas1Relation)+"     "+cas1List.size() );
            for (SysRoleUserRel sysRoleUserRel : cas1List) {
                Integer roleId = sysRoleUserRel.getRoleId();
                String ids = roleRelation.get(roleId+"");
                System.out.println(roleId+"    213    "+ids);
                if(StringUtils.isNotBlank(ids)){
                    String[] roleArr = ids.split(",");
                    for (String cas2RoleId : roleArr) {
                        SysRoleUserRelForCas2 cas2Role = new SysRoleUserRelForCas2();
                        cas2Role.setRoleId(cas2RoleId);
                        cas2Role.setUserId(cas1Relation.getId());
                        sysRoleUserRelForCas2s.add(cas2Role);
                    }
                }

            }
        }
        DatabaseContextHolder.setDatabaseType(DatabaseType.mytestdb2);
        if(!CollectionUtils.isEmpty(sysRoleUserRelForCas2s)){
            List<SysRoleUserRelForCas2> onLineCas2 = new ArrayList<>();
            for (SysRoleUserRelForCas2 sysRoleUserRelForCas2 : sysRoleUserRelForCas2s) {
                SysUser stageUser = sysUserMapper.selectByPrimaryKey(sysRoleUserRelForCas2.getUserId());
                SysRoleUserRelForCas2 onLine = new SysRoleUserRelForCas2();
                onLine.setUserId(stageUser.getSerialNum());
                onLine.setRoleId(sysRoleUserRelForCas2.getRoleId());
                onLineCas2.add(onLine);

            }
            sysRoleUserRelForCas2Mapper.insertList(onLineCas2);
            sysRoleUserRelForCas2Mapper.insertList(sysRoleUserRelForCas2s);
        }

    }




    private void addUserAndRelation(List<SysUser> userList, List<Cas1Relation> cas1RelationList, SysUsers sysUsers, SysCompany sysCompany) {
        if(sysCompany != null){
            SysUser sysUser = addUser(userList, sysCompany, sysUsers);
            Cas1Relation cas1Relation = new Cas1Relation();
            cas1Relation.setId(sysUser.getId());
            cas1Relation.setType("User");
            cas1Relation.setCas1Id(sysUsers.getId() + "");
            cas1RelationList.add(cas1Relation);
        }
    }

    private SysUser addUser(List<SysUser> userList, SysCompany sysCompany, SysUsers sysUsers) {
        SysUser sysUser = new SysUser();
        sysUser.setId(IdGenerater.uuid());
        sysUser.setCreatedBy("脚本导入");
        sysUser.setCreatedOn(new Date());
        sysUser.setIsDelete((byte) 0);
        sysUser.setIsAvailable((byte) 1);
        sysUser.setPassword("123456");
        sysUser.setCompany(sysCompany);
        sysUser.setCompanyId(sysCompany.getId());
        sysUser.setLoginName(sysUsers.getUsername());
        sysUser.setRealName(sysUsers.getTruename());
        sysUser.setMobile(sysUsers.getMobile());
        sysUser.setEmail(sysUsers.getEmail());
        sysUser.setGender((byte) 1);
        sysUser.setBirth(null);
        sysUser.setStatus(check);
        sysUser.setDataType(stage);
        sysUser.setFace((byte) 1);
        sysUser.setOnline((byte) 1);
        sysUser.setCoreStaffId(IdGenerater.nextId());
        userList.add(sysUser);
        return sysUser;
    }

    private SysCompany initSysCompany() {
        SysCompany sysCompany = new SysCompany();
        sysCompany.setId(IdGenerater.nextId());
        sysCompany.setCreatedBy("脚本导入");
        sysCompany.setCreatedOn(new Date());
        sysCompany.setIsDelete((byte) 0);
        sysCompany.setIsAvailable((byte) 1);
        sysCompany.setStatus(check);
        sysCompany.setDataType(stage);
        sysCompany.setCanAcp(false);
        sysCompany.setCanCapital(false);
        sysCompany.setCanDealer(false);
        sysCompany.setCanHelpMortgage(false);
        sysCompany.setCanSp(false);
        sysCompany.setCanMortgage(false);
        sysCompany.setCanVisit(false);
        sysCompany.setIsQualityDealer(false);
        sysCompany.setCanDocument(false);
        sysCompany.setCoreCustomerId(IdGenerater.nextId());
        return sysCompany;
    }

    private void insertUser(List<SysUser> userList)throws Exception  {
        DatabaseContextHolder.setDatabaseType(DatabaseType.mytestdb2);
        List<SysUser> onLineList = new ArrayList<>();
        List<CustomerStaff> staffList = new ArrayList<>();
        List<CustomerStaffAccount> staffAccountList = new ArrayList<>();
        for (SysUser stageUser : userList) {
            if("admin".equals(stageUser.getLoginName())){
                stageUser.setLoginName("admin123");
            }
            SysUser onLineUser = new SysUser();
            BeanUtils.object2Object(stageUser,onLineUser);
            onLineUser.setId(IdGenerater.nextId());
            onLineUser.setCreatedBy(stageUser.getCreatedBy());
            onLineUser.setDataType(online);
            onLineUser.setCompanyId(stageUser.getCompany().getSerialNum());
            onLineUser.setSerialNum(stageUser.getId());
            stageUser.setSerialNum(onLineUser.getId());
            onLineList.add(onLineUser);

            CustomerStaff customerStaff = new CustomerStaff();
            customerStaff.setCustomerId(stageUser.getCompany().getCoreCustomerId());
            customerStaff.setId(stageUser.getCoreStaffId());
            customerStaff.setStaffName(stageUser.getRealName());
            customerStaff.setContactMobile(stageUser.getMobile());
            customerStaff.setEmail(stageUser.getEmail());
            customerStaff.setProvince(stageUser.getProvince());
            customerStaff.setCity(stageUser.getCity());
            customerStaff.setDistrict(stageUser.getDistrict());
            customerStaff.setAddress(stageUser.getAddress());
            customerStaff.setAvatar(stageUser.getAvatar());
            customerStaff.setGender(Integer.toString(stageUser.getGender()));
            customerStaff.setCreateBy(stageUser.getCreatedBy());
            customerStaff.setCreateTime(stageUser.getCreatedOn());
            customerStaff.setIsDelete((byte) 0);
            customerStaff.setIsAvailable((byte) 1);
            staffList.add(customerStaff);
            CustomerStaffAccount customerStaffAccount = new CustomerStaffAccount();
            customerStaffAccount.setId(IdGenerater.nextId());
            customerStaffAccount.setCreateTime(new Date());
            customerStaffAccount.setCreateBy(customerStaff.getCreateBy());
            customerStaffAccount.setStaffId(customerStaff.getId());
            customerStaffAccount.setLoginName(stageUser.getLoginName());
            customerStaffAccount.setIsDelete((byte) 0);
            customerStaffAccount.setIsAvailable((byte) 1);
            String salt= IdGenerater.RandomLowerCharater(3);
            String password = stageUser.getPassword()+salt;
            String encode= CryptoUtils.encodeMD5(password);
            customerStaffAccount.setPassword(encode);
            customerStaffAccount.setSalt(salt);
            staffAccountList.add(customerStaffAccount);
        }
        sysUserMapper.insertList(onLineList);
        sysUserMapper.insertList(userList);
        DatabaseContextHolder.setDatabaseType(DatabaseType.mytestdb3);
        customerStaffMapper.insertList(staffList);
        customerStaffAccountMapper.insertList(staffAccountList);
    }

    private void insertCas1Relation(List<Cas1Relation> cas1RelationList) {
        DatabaseContextHolder.setDatabaseType(DatabaseType.mytestdb2);
        cas1RelationMapper.insertList(cas1RelationList);
    }

    private void insertChannel(List<BizChannel> bizChannelList)throws Exception {
        DatabaseContextHolder.setDatabaseType(DatabaseType.mytestdb2);
        List<BizChannel> onLineList = new ArrayList<>();
        for (BizChannel stageChannel : bizChannelList) {
            BizChannel onLineChannel = new BizChannel();
            BeanUtils.object2Object(stageChannel,onLineChannel);
            if("dealer".equals(stageChannel.getChannelRole())){
                onLineChannel.setId(IdGenerater.nextId());
            }else{
                onLineChannel.setId(stageChannel.getId()+"1234567890");
            }

            if(StringUtils.isBlank(stageChannel.getParentId())){
                onLineChannel.setParentId(null);
            }else{
                onLineChannel.setParentId(stageChannel.getParentId()+"1234567890");
            }
            onLineChannel.setCreatedBy(stageChannel.getCreatedBy());
            onLineChannel.setDataType(online);
            onLineChannel.setCompanyId(stageChannel.getCompany().getSerialNum());
            onLineChannel.setSerialNum(stageChannel.getId());
            stageChannel.setSerialNum(onLineChannel.getId());
            onLineList.add(onLineChannel);
        }
        bizChannelMapper.insertList(onLineList);
        bizChannelMapper.insertList(bizChannelList);
    }

    private void insertFinancial(List<BizFinancial> bizFinancialArrayList)throws Exception {
        DatabaseContextHolder.setDatabaseType(DatabaseType.mytestdb2);
        List<BizFinancial> onLineList = new ArrayList<>();
        for (BizFinancial stageFinancial : bizFinancialArrayList) {
            BizFinancial onLineFinancial = new BizFinancial();
            BeanUtils.object2Object(stageFinancial,onLineFinancial);
            onLineFinancial.setId(IdGenerater.nextId());
            onLineFinancial.setCreatedBy(stageFinancial.getCreatedBy());
            onLineFinancial.setCompanyId(stageFinancial.getCompany().getSerialNum());
            onLineFinancial.setDataType(online);
            onLineFinancial.setSerialNum(stageFinancial.getId());
            stageFinancial.setSerialNum(onLineFinancial.getId());
            onLineList.add(onLineFinancial);
        }
        bizFinancialMapper.insertList(onLineList);
        bizFinancialMapper.insertList(bizFinancialArrayList);
    }

    private void insertVisit(List<BizVisit> bizVisitList)throws Exception  {
        DatabaseContextHolder.setDatabaseType(DatabaseType.mytestdb2);
        List<BizVisit> onLineList = new ArrayList<>();
        for (BizVisit stageVisit : bizVisitList) {
            BizVisit onLineVisit = new BizVisit();
            BeanUtils.object2Object(stageVisit,onLineVisit);
            onLineVisit.setId(IdGenerater.nextId());
            onLineVisit.setCreatedBy(stageVisit.getCreatedBy());
            onLineVisit.setDataType(online);
            onLineVisit.setCompanyId(stageVisit.getCompany().getSerialNum());
            onLineVisit.setSerialNum(stageVisit.getId());
            stageVisit.setSerialNum(onLineVisit.getId());
            onLineList.add(onLineVisit);
        }
        bizVisitMapper.insertList(onLineList);
        bizVisitMapper.insertList(bizVisitList);
    }

    private void insertCapital(List<BizCapital> bizCapitalList)throws Exception  {
        DatabaseContextHolder.setDatabaseType(DatabaseType.mytestdb2);
        List<BizCapital> onLineList = new ArrayList<>();
        for (BizCapital stageCapital : bizCapitalList) {
            BizCapital onLineCapital = new BizCapital();
            BeanUtils.object2Object(stageCapital,onLineCapital);
            onLineCapital.setId(IdGenerater.nextId());
            onLineCapital.setCreatedBy(stageCapital.getCreatedBy());
            onLineCapital.setDataType(online);
            onLineCapital.setCompanyId(stageCapital.getCompany().getSerialNum());
            onLineCapital.setSerialNum(stageCapital.getId());
            stageCapital.setSerialNum(onLineCapital.getId());
            onLineList.add(onLineCapital);
        }
        bizCapitalMapper.insertList(onLineList);
        bizCapitalMapper.insertList(bizCapitalList);
    }

    private void insertDocument(List<BizDocument> bizDocumentList)throws Exception {
        DatabaseContextHolder.setDatabaseType(DatabaseType.mytestdb2);
        List<BizDocument> onLineList = new ArrayList<>();
        for (BizDocument stageDocument : bizDocumentList) {
            BizDocument onLineDocument = new BizDocument();
            BeanUtils.object2Object(stageDocument,onLineDocument);
            if("1234567890".equals(stageDocument.getId())){
                onLineDocument.setId("0987654321");
                onLineDocument.setParentId(null);
            }else{
                onLineDocument.setId(IdGenerater.nextId());
                onLineDocument.setParentId("0987654321");
            }

            onLineDocument.setCreatedBy(stageDocument.getCreatedBy());
            onLineDocument.setDataType(online);
            onLineDocument.setCompanyId(stageDocument.getCompany().getSerialNum());
            onLineDocument.setSerialNum(stageDocument.getId());
            stageDocument.setSerialNum(onLineDocument.getId());
            onLineList.add(onLineDocument);
        }
        bizDocumentMapper.insertList(onLineList);
        bizDocumentMapper.insertList(bizDocumentList);
    }

    public void insertCompany(List<SysCompany> list) throws Exception {
        DatabaseContextHolder.setDatabaseType(DatabaseType.mytestdb2);
        List<SysCompany> onLineList = new ArrayList<>();
        for (SysCompany stageCompany : list) {
            SysCompany onLineCompany = new SysCompany();
            BeanUtils.object2Object(stageCompany,onLineCompany);
            onLineCompany.setId(IdGenerater.nextId());
            onLineCompany.setCreatedBy(stageCompany.getCreatedBy());
            onLineCompany.setDataType(online);
            onLineCompany.setSerialNum(stageCompany.getId());
            stageCompany.setSerialNum(onLineCompany.getId());
            onLineList.add(onLineCompany);
        }
        sysCompanyMapper.insertList(onLineList);
        sysCompanyMapper.insertList(list);
        DatabaseContextHolder.setDatabaseType(DatabaseType.mytestdb3);
        customerMapper.insertList(list);
    }

    private void clearCollections(){
        list.clear();
        userList.clear();
        cas1RelationList.clear();
        sysCompanyMap.clear();
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

    /**
     * 导入公司数据时候对于资方 金融 放款公司没有做处理  考虑在导入时候写死对应的公司id或者在导入数据后在cas2数据库里面对相应的公司做操作
     * @throws IOException
     * @throws CloneNotSupportedException
     */
    @Test
    public void importProduct() throws IOException, CloneNotSupportedException {
        DatabaseContextHolder.setDatabaseType(DatabaseType.mytestdb);
        List<Products> productsList = productsMapper.selectByProducts();
        List<Product> productListForCas2 = new ArrayList<>();
        List<ProductFlow> productFlowListForCas2 = new ArrayList<>();
        List<ProductLoan> productLoanListForCas2 = new ArrayList<>();
        List<ProductUsedCarRule> productUsedCarRuleListForCas2 = new ArrayList<>();
        List<Cas1Relation> cas1RelationList = new ArrayList<>();
        for (Products products : productsList) {
            Product cas2Product = new Product();
            cas2Product.setId(IdGenerater.uuid());
            String productCloneId = IdGenerater.uuid();
            cas2Product.setCreatedBy("脚本导入");
            cas2Product.setCreatedOn(new Date());
            cas2Product.setIsDelete((byte) 0);
            cas2Product.setIsAvailable((byte) 1);
            cas2Product.setCode(products.getCode());
            cas2Product.setExamine((byte) 1);
            cas2Product.setStatus("1");
            cas2Product.setIsRobbery(false);
            cas2Product.setIsGps(false);
            cas2Product.setIsMatchLoanyear("0");
            cas2Product.setName(products.getName());
            cas2Product.setDescribes(products.getDescribe());
            if(products.getIsGuakao() != null && products.getIsGuakao()){
                cas2Product.setBusinessType("[\"natural_affiliated\"]");
                cas2Product.setIsAffiliated(true);
            }else{
                cas2Product.setBusinessType("[\"natural\"]");
                cas2Product.setIsAffiliated(false);
            }
            if(products.getUsedCar()){
                cas2Product.setProductType("2");
                if(StringUtils.isNotBlank(products.getMaxKm())){
                    cas2Product.setMaxMileage(Double.parseDouble(products.getMaxKm()));
                }
                cas2Product.setMaterialPackageId("010895c340ff4ffb807a2ba68c760c7f");
                String carageLimit = products.getCarageLimit();
                if(StringUtils.isNotBlank(carageLimit) && !"0".equals(carageLimit)){
                    List<JSONObject> jsonObjects = JSONArray.parseArray(carageLimit, JSONObject.class);
                    for (JSONObject jsonObject : jsonObjects) {
                        ProductUsedCarRule productUsedCarRule = new ProductUsedCarRule();
                        productUsedCarRule.setId(IdGenerater.uuid());
                        productUsedCarRule.setCreatedBy("脚本导入");
                        productUsedCarRule.setCreatedOn(new Date());
                        productUsedCarRule.setIsDelete((byte) 0);
                        productUsedCarRule.setIsAvailable((byte) 1);
                        productUsedCarRule.setProductId(cas2Product.getId());
                        productUsedCarRule.setMinAmount(jsonObject.getBigDecimal("min"));
                        productUsedCarRule.setMaxAmount(jsonObject.getBigDecimal("max"));
                        productUsedCarRule.setYear(jsonObject.getDouble("year"));
                        ProductUsedCarRule clone = productUsedCarRule.clone();
                        clone.setId(IdGenerater.uuid());
                        clone.setProductId(productCloneId);
                        productUsedCarRuleListForCas2.add(clone);
                        productUsedCarRuleListForCas2.add(productUsedCarRule);
                    }
                }
            }else{
                cas2Product.setProductType("1");
                cas2Product.setMaterialPackageId("5d5feb3c5ea265d52937f4eff425f495");
            }
            cas2Product.setIsImprest(products.getIsImprest());
            cas2Product.setRepayType(products.getRepaymentType());
            cas2Product.setPerUpper(0);
            cas2Product.setFirstUpper(Integer.parseInt(products.getMinLoan()));
            cas2Product.setInsuranceProductCode("");//盗抢产品编码
            cas2Product.setMinDownPayment(JSON.parseObject(products.getDownpaymentRateRange()).getBigDecimal("min"));
            cas2Product.setMaxDownPayment(JSON.parseObject(products.getDownpaymentRateRange()).getBigDecimal("max"));
            cas2Product.setMinLoan(JSON.parseObject(products.getLoanmoneyRange()).getBigDecimal("min"));
            cas2Product.setMaxLoan(JSON.parseObject(products.getLoanmoneyRange()).getBigDecimal("max"));
            cas2Product.setMaxLoanRate(products.getLoanrate());
            cas2Product.setOverrate(products.getOverrate());

            String overloanFormulaId = products.getOverloanFormulaId();//CAS1 超融公式

            if("11".equals(overloanFormulaId)){
                cas2Product.setOverrateFormulaId("calculationFinancialAmountForPrincipal");
            }else{
                cas2Product.setOverrateFormulaId("calculationFinancialAmountForCarPrice");
            }
            cas2Product.setOverdraftFormulaId("calculationOverdraft");//透支总额
            Byte formulaId = products.getProductLoansList().get(0).getFormulaId();//CAS1 月供公式
            if(9 == formulaId){
                cas2Product.setOverrateFormulaId("calculationYearMonthlyCompoundInterest");
            }else{
                cas2Product.setOverrateFormulaId("calculationAccrualMonthlyRate");
            }
            cas2Product.setBaofeiFormulaId("calculationPremium");
            Boolean intOver = products.getIntOver();
            String baoeFormulaId = products.getBaoeFormulaId();
            if("4".equals(baoeFormulaId)){
                cas2Product.setBaoeFormulaId("calculationBaoeForOverdraft");
            }else{
                cas2Product.setBaoeFormulaId("calculationBaoeForTotalAmount");
            }
            if(intOver){
                cas2Product.setLoanamountFormulaId("calculationTotalAmountForRoundUp");
            }else{
                cas2Product.setLoanamountFormulaId("calculationTotalAmount");
            }
            cas2Product.setDiscount("no"); //是否贴息
            cas2Product.setCapitalCompanyId("");//资方公司
            Byte feerate = products.getFeerate();
            if(1 == feerate){
                cas2Product.setFeerate(2);
            }else {
                cas2Product.setFeerate(1);
            }
            List<ProductLoans> productLoansList = products.getProductLoansList();
            for (ProductLoans productLoans : productLoansList) {
                ProductLoan productLoan = new ProductLoan();
                productLoan.setId(IdGenerater.uuid());
                productLoan.setCreatedBy("脚本导入");
                productLoan.setCreatedOn(new Date());
                productLoan.setIsDelete((byte) 0);
                productLoan.setIsAvailable((byte) 1);
                productLoan.setProductId(cas2Product.getId());

                productLoan.setMonthNum(productLoans.getMonthNum().toString());
                productLoan.setManageFeeType("1");
                productLoan.setManageFee(new BigDecimal(productLoans.getManageFee()));
                productLoan.setInterest(new BigDecimal(productLoans.getInterest()));
                productLoan.setRent(new BigDecimal(productLoans.getRent()));
                productLoan.setInsuranceRate(new BigDecimal(productLoans.getBaoxianRate()));
                productLoan.setInsuranceMultiRate(new BigDecimal(productLoans.getBaoxianbeiRate()));
                productLoan.setMonthStatus(true);
                ProductLoan clone = productLoan.clone();
                clone.setId(IdGenerater.uuid());
                clone.setProductId(productCloneId);
                productLoanListForCas2.add(clone);
                productLoanListForCas2.add(productLoan);
            }

            ProductFlow productFlow = new ProductFlow();
            productFlow.setId(IdGenerater.uuid());
            productFlow.setCreatedBy("脚本导入");
            productFlow.setCreatedOn(new Date());
            productFlow.setIsDelete(false);
            productFlow.setIsAvailable(true);
            productFlow.setProductId(cas2Product.getId());
            productFlow.setQualificationTemplateId("qualification");
            productFlow.setLoanTemplateId("loanApproval");
            productFlow.setInsuranceTemplateId("insurance");
            productFlow.setCapitalTemplateId("shjz_capital");
            productFlow.setPledgeTemplateId("mortgage");
            productFlow.setNeedInsurance((byte) 1);
            ProductFlow flowClone = productFlow.clone();
            flowClone.setId(IdGenerater.uuid());
            flowClone.setProductId(productCloneId);
            productFlowListForCas2.add(flowClone);
            productFlowListForCas2.add(productFlow);

            cas2Product.setDataType("stage");
            cas2Product.setAudit("1");
            cas2Product.setSerialNum(productCloneId);
            Product clone = cas2Product.clone();

            clone.setId(productCloneId);
            clone.setDataType("online");
            clone.setSerialNum(cas2Product.getId());


            productListForCas2.add(cas2Product);
            productListForCas2.add(clone);

            Cas1Relation cas1Relation = new Cas1Relation();
            cas1Relation.setId(cas2Product.getId());
            cas1Relation.setType("Product");
            cas1Relation.setCas1Id(products.getId()+"");
            Cas1Relation cas1RelationClone = cas1Relation.clone();
            cas1RelationClone.setId(productCloneId);
            cas1RelationList.add(cas1RelationClone);
            cas1RelationList.add(cas1Relation);

        }
        DatabaseContextHolder.setDatabaseType(DatabaseType.mytestdb2);
        for (Product product : productListForCas2) {
            productMapper.insert(product);
        }
        for (ProductLoan productLoan : productLoanListForCas2) {
            productLoanMapper.insert(productLoan);
        }

        for (ProductFlow productFlow : productFlowListForCas2) {
            productFlowMapper.insert(productFlow);
        }
        for (ProductUsedCarRule productUsedCarRule : productUsedCarRuleListForCas2) {
            productUsedCarRuleMapper.insert(productUsedCarRule);
        }

        for (Cas1Relation cas1Relation : cas1RelationList) {
            cas1RelationMapper.insert(cas1Relation);
        }

    }
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
//            throw new RuntimeException("推送核心数据库--公司数据失败"); 4600
//        }
//
//        return id;
//    }

}
