package mnj.ont.model.view.backing.bean;

import java.sql.CallableStatement;

import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;

import javax.faces.event.ValueChangeEvent;

import javax.servlet.http.HttpSession;

import model.services.AppModuleImpl;

import oracle.adf.model.BindingContext;

import oracle.adf.view.rich.component.rich.input.RichInputDate;
import oracle.adf.view.rich.component.rich.layout.RichShowDetailItem;

import oracle.binding.BindingContainer;
import oracle.binding.OperationBinding;

import oracle.adf.model.binding.DCBindingContainer;
import oracle.adf.model.binding.DCDataControl;
import oracle.adf.view.rich.component.rich.RichPopup;
import oracle.adf.view.rich.component.rich.data.RichTable;
import oracle.adf.view.rich.component.rich.input.RichInputComboboxListOfValues;
import oracle.adf.view.rich.component.rich.input.RichInputListOfValues;
import oracle.adf.view.rich.component.rich.input.RichInputText;
import oracle.adf.view.rich.component.rich.output.RichOutputText;
import oracle.adf.view.rich.context.AdfFacesContext;

import oracle.adf.view.rich.event.DialogEvent;

import oracle.adf.view.rich.event.PopupFetchEvent;


import oracle.jbo.ApplicationModule;
import oracle.jbo.Key;
import oracle.jbo.Row;
import oracle.jbo.RowSet;
import oracle.jbo.RowSetIterator;
import oracle.jbo.ViewObject;

public class ManagedBean {
    
    private RichTable matTable;
    private RichOutputText fillBPORowCount;
    private RichInputText bind_VersionNo;
    private RichInputListOfValues buyerNameNew;
    private RichInputComboboxListOfValues season;
    private RichInputText bind_OrgID;
    private RichPopup editDialogListenerNew;
    private RichInputText buyerId;
    private RichTable originaltable;
    private RichShowDetailItem exportLCTab;
    private RichInputDate lastShipmenDate;
    private RichInputText contractExpiryDate;
    private RichInputText contractBind;
    private RichTable amendTableNew;
    private RichInputText contractQuantity;
    private RichTable amendtable;
    private RichTable styleWiseQtyCalu;

    public ManagedBean() {
        super();
    }

    public void setMatTable(RichTable matTable) {
        this.matTable = matTable;
    }

    public RichTable getMatTable() {
        return matTable;
    }
    
    public OperationBinding executeOperation(String operation) {
    OperationBinding createParam = getBindingsCont().getOperationBinding(operation);
    return createParam;

    }
    

    public BindingContainer getBindings() {
    return BindingContext.getCurrent().getCurrentBindingsEntry();
    }

    /*****Generic Method to Get BindingContainer**/
    public BindingContainer getBindingsCont() {
    return BindingContext.getCurrent().getCurrentBindingsEntry();
    }
    
    public ApplicationModule getAppM(){
        DCBindingContainer bindingContainer =
            (DCBindingContainer)BindingContext.getCurrent().getCurrentBindingsEntry();
        //BindingContext bindingContext = BindingContext.getCurrent();
        DCDataControl dc =
            bindingContainer.findDataControl("AppModuleDataControl"); // Name of application module in datacontrolBinding.cpx
        AppModuleImpl appM = (AppModuleImpl)dc.getDataProvider();
        return appM;
    }
    AppModuleImpl appM = (AppModuleImpl)this.getAppM();
    
    public void selectAll(ActionEvent actionEvent) {
        try {
            ViewObject vo = appM.getFillBPOVO1();
            vo.setRangeSize(1000);
            Row[] rowArray = vo.getAllRowsInRange();
            System.out.println("row length: " + fillBPORowCount.getValue().toString());
//            vo.setRangeSize(Integer.parseInt(fillBPORowCount.getValue().toString()));
            for (Row newRow : rowArray){
                newRow.setAttribute("CheckBox", "Y");
            }
            AdfFacesContext.getCurrentInstance().addPartialTarget(matTable);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void setFillBPORowCount(RichOutputText fillBPORowCount) {
        this.fillBPORowCount = fillBPORowCount;
    }

    public RichOutputText getFillBPORowCount() {
        return fillBPORowCount;
    }

    public void DeSelectAll(ActionEvent actionEvent) {
        // Add event code here...
        
        try {
            ViewObject vo = appM.getFillBPOVO1();
            vo.setRangeSize(1000);
            Row[] rowArray = vo.getAllRowsInRange();
            System.out.println("row length: " + fillBPORowCount.getValue().toString());
        //            vo.setRangeSize(Integer.parseInt(fillBPORowCount.getValue().toString()));
            for (Row newRow : rowArray){
                newRow.setAttribute("CheckBox", "N");
            }
            AdfFacesContext.getCurrentInstance().addPartialTarget(matTable);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    public void editDialogListenerNew(DialogEvent dialogEvent) {
        if (dialogEvent.getOutcome().name().equals("ok")) {     
          FillBPO();
          AdfFacesContext.getCurrentInstance().addPartialTarget(originaltable);
         
         System.out.println("======================= OK ===============");
             
        } else if (dialogEvent.getOutcome().name().equals("cancel")) {          
         
         ;
            System.out.println("===================== Cencel ===============");
        }
    }
    
    /* For Pop-Up of Original */

    public void FillBPO() {
        
    ViewObject populatevo = appM.getFillBPOVO1();
    System.out.println("================== callBpoFetch() :"+ populatevo.getAllRowsInRange().length);
    String flag;
    Double totalValue;
    Row r[] = populatevo.getAllRowsInRange();
    for (Row row : r) {
 //   System.out.println("loop count");
    try {
    totalValue =Double.parseDouble(row.getAttribute("Totalvalue").toString()) ;
    // System.out.println(" Total Value -->" + totalValue);    
    flag = row.getAttribute("CheckBox").toString();
    // System.out.println("Flag Code -->" + flag);
    if (flag.equals("Y") && totalValue >0)
       populateMaterialLines(row);
    } 
    
    catch (Exception e) {
              ;
          }

    }
}
 
/*
   
    public void populateMaterialLines(Row poprow) {
        
        System.out.println("populateMaterialLines ....");
        ViewObject vo = appM.getImpSaleContrLinesVO1();
      //  String BuyerId = getBuyerid();   //getImpSaleContrHeader1
       
       Row linerow = createMaterialLines(); //getImpSaleContrLines1();

       linerow.setAttribute("BpoNo",getPopulateValue(poprow, "Bpo"));
        
       linerow.setAttribute("StyleNo",getPopulateValue(poprow, "Style"));
        
       linerow.setAttribute("Attribute2",getPopulateValue(poprow, "Classification"));

       linerow.setAttribute("ItemDescription",getPopulateValue(poprow, "StyleDescription"));
        
       linerow.setAttribute("Quantity",getPopulateValue(poprow, "Quantity"));
        
       linerow.setAttribute("UnitPrice",getPopulateValue(poprow, "Unitprice"));
        
       linerow.setAttribute("TotalValue",getPopulateValue(poprow, "Totalvalue"));
        
       linerow.setAttribute("ShipExFactoryDate",getPopulateValue(poprow, "Shipdate"));
       
       linerow.setAttribute("ShipCancelExBdDate",getPopulateValue(poprow, "Enddate"));
        
       linerow.setAttribute("Attribute1",getPopulateValue(poprow, "LineId"));
       
       linerow.setAttribute("BpoId",getPopulateValue(poprow, "BpoId"));

       linerow.setAttribute("SalesTerm",getPopulateValue(poprow, "Incoterms"));
        
       linerow.setAttribute("LastQty",getPopulateValue(poprow, "Quantity"));

       linerow.setAttribute("LastPrice",getPopulateValue(poprow, "Unitprice"));

       linerow.setAttribute("LastTotalPrice",getPopulateValue(poprow, "Totalvalue"));
            
       linerow.setAttribute("Status",getPopulateValue(poprow, "VersionNo"));
              
      //      populateBpoLines(BuyerId);
        } //end of populateLines
 
 
    
 */
  public void populateMaterialLines(Row poprow) {

  System.out.println("populateMaterialLines  ....");
  ViewObject vo = appM.getImpSaleContrLinesVO1();
  // String BuyerId = getBuyerid(); //getImpSaleContrHeader1

  Row linerow;

  Row[] bpoIdMatchedRows = vo.getFilteredRows("BpoId", poprow.getAttribute("BpoId").toString() );

  System.out.println("poprow.getAttribute(\"BpoId\").toString() " + poprow.getAttribute("BpoId").toString() );

  System.out.println("================= bpoIdMatchedRows.length : "+ bpoIdMatchedRows.length);

  if (bpoIdMatchedRows.length==0) {
      
     System.out.println("  === bpoIdMatchedRows.length==0 ==   ");
     
     linerow = createMaterialLines(); //getImpSaleContrLines1();
     
     linerow.setAttribute("OldBpo",getPopulateValue(poprow, "Bpo"));
     
     linerow.setAttribute("BpoNo",getPopulateValue(poprow, "Bpo"));

     linerow.setAttribute("StyleNo",getPopulateValue(poprow, "Style"));

     linerow.setAttribute("Attribute2",getPopulateValue(poprow, "Classification"));

     linerow.setAttribute("ItemDescription",getPopulateValue(poprow, "StyleDescription"));

     linerow.setAttribute("Quantity",getPopulateValue(poprow, "Quantity"));

     linerow.setAttribute("UnitPrice",getPopulateValue(poprow, "Unitprice"));

     linerow.setAttribute("TotalValue",getPopulateValue(poprow, "Totalvalue"));

     linerow.setAttribute("ShipExFactoryDate",getPopulateValue(poprow, "Shipdate"));

     linerow.setAttribute("ShipCancelExBdDate",getPopulateValue(poprow, "Enddate"));

     linerow.setAttribute("Attribute1",getPopulateValue(poprow, "LineId"));

     linerow.setAttribute("BpoId",getPopulateValue(poprow, "BpoId"));

     linerow.setAttribute("SalesTerm",getPopulateValue(poprow, "Incoterms"));

     linerow.setAttribute("LastQty",getPopulateValue(poprow, "Quantity"));

     linerow.setAttribute("LastPrice",getPopulateValue(poprow, "Unitprice"));

     linerow.setAttribute("LastTotalPrice",getPopulateValue(poprow, "Totalvalue"));

     linerow.setAttribute("Status",getPopulateValue(poprow, "VersionNo"));

  }
//  else if (bpoIdMatchedRows.length==1) {
//  
// System.out.println("  === bpoIdMatchedRows.length==1 ==   ");
//  linerow = bpoIdMatchedRows[0];
//  }
  
  
  else{
      
      
     System.out.println("=========  ELSE =============   ");
      
      linerow = bpoIdMatchedRows[0];
      
      linerow.setAttribute("BpoNo",getPopulateValue(poprow, "Bpo"));
        
      linerow.setAttribute("ShipExFactoryDate",getPopulateValue(poprow, "Shipdate"));

      linerow.setAttribute("StyleNo",getPopulateValue(poprow, "Style"));
      
      linerow.setAttribute("BpoId",getPopulateValue(poprow, "BpoId"));
      
      linerow.setAttribute("LastQty",getPopulateValue(poprow, "Quantity"));

      linerow.setAttribute("LastPrice",getPopulateValue(poprow, "Unitprice"));

      linerow.setAttribute("LastTotalPrice",getPopulateValue(poprow, "Totalvalue"));
 
      linerow.setAttribute("Status",getPopulateValue(poprow, "VersionNo"));
//
//      linerow.setAttribute("Attribute2",getPopulateValue(poprow, "Classification"));
//
//      linerow.setAttribute("ItemDescription",getPopulateValue(poprow, "StyleDescription"));
//
//      linerow.setAttribute("Quantity",getPopulateValue(poprow, "Quantity"));
//
//      linerow.setAttribute("UnitPrice",getPopulateValue(poprow, "Unitprice"));
//
//      linerow.setAttribute("TotalValue",getPopulateValue(poprow, "Totalvalue"));
//

//
//      linerow.setAttribute("ShipCancelExBdDate",getPopulateValue(poprow, "Enddate"));
//
//      linerow.setAttribute("Attribute1",getPopulateValue(poprow, "LineId"));
//
//        linerow.setAttribute("BpoId",getPopulateValue(poprow, "BpoId"));
//
//       linerow.setAttribute("SalesTerm",getPopulateValue(poprow, "Incoterms"));
//
//        linerow.setAttribute("LastQty",getPopulateValue(poprow, "Quantity"));

//        linerow.setAttribute("LastPrice",getPopulateValue(poprow, "Unitprice"));

//        linerow.setAttribute("LastTotalPrice",getPopulateValue(poprow, "Totalvalue"));
//
//        linerow.setAttribute("Status",getPopulateValue(poprow, "VersionNo"));
 
  }


  // populateBpoLines(BuyerId);
  } //end of populateLines
  
        public Row createMaterialLines() {
            
            System.out.println("===================== createMaterialLines step-1==================");
            ViewObject vo = appM.getImpSaleContrLinesVO1();
            System.out.println("===================== createMaterialLines step-2==================");
            Row row = vo.createRow();
            System.out.println("===================== createMaterialLines step-3==================");
          //  vo.insertRow(row);
            vo.insertRow(row);
            System.out.println("===================== createMaterialLines step-4==================");
            row.setNewRowState(Row.STATUS_INITIALIZED);
            return row;
        } //end of createHeader
        
        public String getPopulateValue(Row r, String columnName) {
         
           String value = null;
       
        try {
            value = r.getAttribute(columnName).toString();
            System.out.println("===================== getPopulateValue =================="+value);
        } catch (Exception e) {
                 ;
            }
            return value;
        }

    public void setBind_VersionNo(RichInputText bind_VersionNo) {
        //System.out.println("SETTER 1");
        //System.out.println("SETTER 2");
        
        FacesContext fctx = FacesContext.getCurrentInstance();
        ExternalContext ectx = fctx.getExternalContext();
        HttpSession userSession = (HttpSession) ectx.getSession(false);
        String vVersionNo=null;
        
        System.out.println("ABC ----->>>>123");
        try {           //System.out.println("ABC ----->>>>"+getVersionNo_Bind().getValue().toString());
        vVersionNo=bind_VersionNo.getValue().toString();
        System.out.println("ABC ---SA-->>>>123   "+vVersionNo);
                                  
        userSession.setAttribute("VersionNo",vVersionNo);    
                                
        System.out.println("ABC ----->>>>"+vVersionNo);
                           }
        catch (Exception e ){
            System.out.println("Error "+e.getMessage());
            
           ;}
        this.bind_VersionNo = bind_VersionNo;
    }

    public RichInputText getBind_VersionNo() {
        return bind_VersionNo;
    }
    
    public void setbuyerName(RichInputListOfValues id){
            
            FacesContext fctx = FacesContext.getCurrentInstance();
            ExternalContext ectx = fctx.getExternalContext();
            HttpSession userSession = (HttpSession) ectx.getSession(false);
            userSession.setAttribute("buyerName", id.getValue());    
        }

    public void setBuyerNameNew(RichInputListOfValues buyerNameNew) {
        
        FacesContext fctx = FacesContext.getCurrentInstance();
        ExternalContext ectx = fctx.getExternalContext();
        HttpSession userSession = (HttpSession) ectx.getSession(false);
        String vBuyerName=null;
        
        System.out.println("ABC ---BUYERNAME-->>>>123");
        try {           //System.out.println("ABC ----->>>>"+getVersionNo_Bind().getValue().toString());
        vBuyerName =buyerNameNew.getValue().toString();//   getBuyerNameNew().getValue().toString();
        // System.out.println("Buyer Name------->>"+ vBuyerName);
        userSession.setAttribute("BuyerName",vBuyerName);    
                           }
        catch (Exception e ){
            System.out.println("Error "+e.getMessage());
           ;}
        this.buyerNameNew = buyerNameNew;
        setbuyerName(buyerNameNew);
    }

    public RichInputListOfValues getBuyerNameNew() {
        return buyerNameNew;
    }

    public void setSeason(RichInputComboboxListOfValues season) {
        FacesContext fctx = FacesContext.getCurrentInstance();
        ExternalContext ectx = fctx.getExternalContext();
        HttpSession userSession = (HttpSession)ectx.getSession(false);
        String vSeason = null;

        System.out.println("ABC ----->>>>123");
        try { //System.out.println("ABC ----->>>>"+getVersionNo_Bind().getValue().toString());
            vSeason =
                    season.getValue().toString(); // getSeason().getValue().toString();
            System.out.println("Season------->>" + vSeason);
            userSession.setAttribute("Season", vSeason);
        } catch (Exception e) {
            //   System.out.println("Error "+e.getMessage());
            ;
        }
        this.season = season;
    }

    public RichInputComboboxListOfValues getSeason() {
        return season;
    }

    public void setBind_OrgID(RichInputText bind_OrgID) {
        
        FacesContext fctx = FacesContext.getCurrentInstance();
        ExternalContext ectx = fctx.getExternalContext();
        HttpSession userSession = (HttpSession) ectx.getSession(false);
        String vOrgID=null;
        
        System.out.println("ABC --ORG_ID--->>>>123");
        try {           //System.out.println("ABC ----->>>>"+getVersionNo_Bind().getValue().toString());
        vOrgID=bind_OrgID.getValue().toString();  //getBind_OrgID().getValue().toString();                           
         
                               
             userSession.setAttribute("OrgID",vOrgID);    
             System.out.println("ABC1 --- ORG_ID----->>>>"+vOrgID);
            
            }
        
        catch (Exception e ){
         //   System.out.println("Error "+e.getMessage());
            
           ;}
        this.bind_OrgID = bind_OrgID;
    }

    public RichInputText getBind_OrgID() {
        return bind_OrgID;
    }
    
    public void setBuyerId(RichInputText buyerId) {
        
        FacesContext fctx = FacesContext.getCurrentInstance();
        ExternalContext ectx = fctx.getExternalContext();
        HttpSession userSession = (HttpSession) ectx.getSession(false);
        String vBuyerId=null;
        
        System.out.println("ABC ---BUYER_ID-->>>>123");
        try {           //System.out.println("ABC ----->>>>"+getVersionNo_Bind().getValue().toString());
    
         vBuyerId =buyerId.getValue().toString();//   getBuyerNameNew().getValue().toString();       
         System.out.println("Buyer ID------->>"+ vBuyerId);
         userSession.setAttribute("BuyerId",vBuyerId);    
           }
        catch (Exception e ){
            System.out.println("Error "+e.getMessage());
           ;}
        this.buyerId = buyerId;
    }

    public RichInputText getBuyerId() {
        return buyerId;
    }
    
    public void setEditDialogListenerNew(RichPopup editDialogListenerNew) {
        this.editDialogListenerNew = editDialogListenerNew;
    }

    public RichPopup getEditDialogListenerNew() {
        return editDialogListenerNew;
    }

    public void editDialogListenerNew(PopupFetchEvent popupFetchEvent) {
        // Add event code here...               
           System.out.println("in  editPopupFetchListener line 101");
           setWhereClause();
        //            
        //              if (popupFetchEvent.getLaunchSourceClientId().contains("cbInsert")) {
        //                
        //                  BindingContainer bindings = getBindings();
        //                  OperationBinding operationBinding = bindings.getOperationBinding("CreateInsert");
        //                  operationBinding.execute();
        //              }
        
    }
    
    public void setWhereClause(){ 
    
    System.out.println("populateBpoLines ...");
    ViewObject populatevo = appM.getFillBPOVO1();
    String BuyerId = getBuyerid();
    String Season = getSeason1();
    String unit=null;
    
        ViewObject vo = appM.getImpSaleContrHeaderVO1();
        
        try {

            unit =
                    vo.getCurrentRow().getAttribute("OrgId").toString();

        } catch (Exception e) {
            // TODO: Add catch code
           unit=null;  ;
        }
    
    System.out.println(BuyerId);
    System.out.println(Season);
    System.out.println("Faraz 1------------->>");
    System.out.println("BuyerID = '"+ BuyerId +"'"+" AND SEASON = '"+ Season +"'");
    System.out.println("BPO Query--------->>>"+populatevo.getQuery());
    
    /****************added by arif******/
    populatevo.clearCache();
            populatevo.setWhereClause(null);
            populatevo.setWhereClauseParam(0, unit);
        populatevo.setWhereClauseParam(1, Season);
        populatevo.setWhereClauseParam(2, BuyerId);
            populatevo.executeQuery();
            populatevo.first();
    
    
    // populatevo.setWhereClause
    // ("BUYER_NAME = " +"'"+BuyerName+"'"+" AND SEASON = "+"'"+Season+"'");

    //populatevo.setWhereClause ("BUYER_ID = '"+ BuyerId +"'"+" AND SEASON = '"+ Season +"'"+" AND LC_UNIT = '"+ unit +"'");
    System.out.println("Faraz 2------------->>");
       // populatevo.executeQuery();
    System.out.println("BuyerID = '"+ BuyerId +"'"+" AND SEASON = '"+ Season +"'");

    //populatevo.executeQuery();

    System.out.println("Faraz 3------------->>");
    System.out.println("BuyerID = '"+ BuyerId +"'"+" AND SEASON = '"+ Season +"'");
    
    System.out.println("Faraz 4 ------------->>");
    System.out.println("populatevo.getRowCount() "+populatevo.getRowCount());

  /*  if (populatevo.getRowCount() == 0) {
    System.out.println("populatevo.getRowCount() "+populatevo.getRowCount());
    populatevo.setWhereClause(null);
    // populatevo.setWhereClause("BUYER_NAME = " + BuyerName);
    System.out.println("populatevo.getRowCount() "+populatevo.getRowCount());
    populatevo.setWhereClause("BUYER_ID= '"+ BuyerId +"'");

    populatevo.executeQuery();
    System.out.println("Faraz 4------------->>");
  //  System.out.println("BuyerID = '"+ BuyerID +"'"+" AND SEASON = '"+ Season +"'");

    }*/

    //System.out.println("Faraz 4------------->>");
    //System.out.println("BUYER_NAME = '"+ BuyerName +"'"+" AND SEASON = '"+ Season +"'");
        
    }
    

    public String getBuyerid(){
           
           ViewObject vo = appM.getImpSaleContrHeaderVO1();
           String BuyerId = null;
           try {

               BuyerId = vo.getCurrentRow().getAttribute("BuyerId").toString();

           } catch (Exception e) {
               // TODO: Add catch code
               ;
           }
               return BuyerId;
       }
       
     
       public String getBuyerName(){
           
               
           ViewObject vo = appM.getImpSaleContrHeaderVO1();
           String BuyerName = null;
           try {

               BuyerName =
                       vo.getCurrentRow().getAttribute("BuyerNameNew").toString();

           } catch (Exception e) {
               // TODO: Add catch code
               ;
           }
               return BuyerName;
       }  
       
       
       public String getSeason1(){
           
               
           ViewObject vo = appM.getImpSaleContrHeaderVO1();
           String Season = null;
           try {

               Season =
                       vo.getCurrentRow().getAttribute("Season").toString();

           } catch (Exception e) {
               // TODO: Add catch code
               ;
           }
               return Season;
       }    
       
       /* End For Original */

    public void setOriginaltable(RichTable originaltable) {
        this.originaltable = originaltable;
    }

    public RichTable getOriginaltable() {
        return originaltable;
    }

    public void deleteAllFromLine(ActionEvent actionEvent) {
        // Add event code here...
        ViewObject lineVO = appM.getImpSaleContrLinesVO1();
        // lineVO.setRangeSize(1000);
        Row[] rows = lineVO.getAllRowsInRange();
        for(Row row : rows){
        row.remove();
        }
        AdfFacesContext.getCurrentInstance().addPartialTarget(originaltable);
    }

    public String NewSave() {
        // Add event code here...
        save();
        return null;
    }
    
    public String save() {
    getLastShipmentDate();
    AdfFacesContext.getCurrentInstance().addPartialTarget(lastShipmenDate);
    AdfFacesContext.getCurrentInstance().addPartialTarget(contractExpiryDate);
    AdfFacesContext.getCurrentInstance().addPartialTarget(contractBind);
    
    System.out.println("========== Before Commit ==========");
    
    appM.getDBTransaction().commit();
    
    System.out.println("========== After Commit ==========");

/*    
    System.out.println("========== getBindings 1 ==========");
    BindingContainer bindings = getBindings();
    System.out.println("========== getBindings 2 ==========");
    OperationBinding operationBinding = bindings.getOperationBinding("Commit");
    System.out.println("========== getBindings 3 ==========");
    Object result = operationBinding.execute();
    System.out.println("========== getBindings 4 ==========");
    if (!operationBinding.getErrors().isEmpty()) {
    System.out.println("========== getBindings 5 ==========");
    return null;
   }
*/
    CalculateTotQty_TotVal();

    AdfFacesContext.getCurrentInstance().addPartialTarget(contractBind);

    AdfFacesContext.getCurrentInstance().addPartialTarget(contractQuantity);

    calculateExportLcTotal();
    
     return null;
    }
    
    public void getLastShipmentDate() {
        ViewObject vo = appM.getImpSaleContrHeaderVO1();
        String headerId1 = vo.getCurrentRow().getAttribute("ImpSaleHeaderId").toString();
        System.out.println("Header Id -->" + headerId1);
        String status =null;
        String stmt ="BEGIN XX_COPY_VERSION_PKG.XX_SC_LAST_SHIP_DATE (:1); end;";
        CallableStatement cs =appM.getDBTransaction().createCallableStatement(stmt,1);
        try {
        // cs.registerOutParameter(1, OracleTypes.VARCHAR);
        cs.setInt(1, Integer.parseInt(headerId1));
        // cs.setInt(2, 'A');
        cs.execute();
        // status = cs.getString(1);
        cs.close();

        } catch (Exception e) {
        status = e.getMessage();
        }
       refreshQueryKeepingCurrentRow();
    }
    
    private void calculateExportLcTotal() {
   
             ViewObject exportLcLineVO = appM.getImpSaleContractDetailEOView1();
             RowSetIterator it = exportLcLineVO.createRowSetIterator(null);
             
             Row exportLcLineVoRow ;
             
             System.out.println("========== calculateExportLcTotal ========");
             
             double elcTotalQty , elcTotalValue;
             RowSet[] rs ;
             
   while(it.hasNext()){
   exportLcLineVoRow = it.next();
    try{
          System.out.println("========== calculateExportLcTotal === loop start ========");
        
           elcTotalQty = getElcTotalQty(exportLcLineVoRow);
        
           exportLcLineVoRow.setAttribute("ExportLcQuantity",elcTotalQty);

           elcTotalValue= getElcTotalValue(exportLcLineVoRow);
        
           exportLcLineVoRow.setAttribute("ExportLcValue",elcTotalValue);
        
        System.out.println("========== calculateExportLcTotal === loop end ========");
        
    }catch(Exception e){
    it.closeRowSetIterator();
    return;
    }

    }

    it.closeRowSetIterator();

    AdfFacesContext.getCurrentInstance().addPartialTarget(contractBind);
    AdfFacesContext.getCurrentInstance().addPartialTarget(contractQuantity);

 }
    
    public double getElcTotalQty(Row exportLcLineVoRow ) {
        
        System.out.println("========== getElcTotalQty == start ========");
         double total=0.0; ;
         double val=0.0 ;
    RowSet rs ;
    rs = (RowSet)exportLcLineVoRow.getAttribute("ImpSaleContractAmendVO1");

    while (rs.hasNext()){

    Row r = rs.next();
    try {
    val = Double.parseDouble(r.getAttribute("Quantity").toString());
    }catch (Exception e ){;}

    total = total + val ;
        
        System.out.println("========== getElcTotalQty ========"+total);
        
    } //end of while loop

    return total ;
    }


    public double getElcTotalValue(Row exportLcLineVoRow) {

    System.out.println("========== getElcTotalValue ==== start ========");
    
    double total =0.0;
    double val=0.0 ;
    RowSet rs ;
    rs = (RowSet)exportLcLineVoRow.getAttribute("ImpSaleContractAmendVO1");

    while (rs.hasNext()){
    Row r = rs.next();
    try {
    val = Double.parseDouble(r.getAttribute("TotalValue").toString());
    }catch (Exception e ){;}

    total = total + val ;
        
        System.out.println("========== getElcTotalValue ========"+total);
    } //end of while loop
      return total;
      
 }
    
    public void refreshQueryKeepingCurrentRow() {
        
    ViewObject vo = appM.getImpSaleContrHeaderVO1();
    Row currentRow = vo.getCurrentRow();
    Key currentRowKey = currentRow.getKey();
    int rangePosOfCurrentRow = vo.getRangeIndexOf(currentRow);
    int rangeStartBeforeQuery = vo.getRangeStart();
    vo.executeQuery();
    vo.setRangeStart(rangeStartBeforeQuery);
    /*
    * In 10.1.2, there is this convenience method we could use
    * instead of the remaining lines of code
    *
    * findAndSetCurrentRowByKey(currentRowKey,rangePosOfCurrentRow);
    *
    */
    
    System.out.println("======================");
    
    Row[] rows = vo.findByKey(currentRowKey, 1);
    if (rows != null && rows.length == 1)
    {
         vo.scrollRangeTo(rows[0], rangePosOfCurrentRow);
         vo.setCurrentRowAtRangeIndex(vo.getRangeIndexOf(rows[0]));
    }

    }
    
    public void CalculateTotQty_TotVal() {
        ViewObject vo = appM.getImpSaleContrHeaderVO1();
        String headerId1 = vo.getCurrentRow().getAttribute("ImpSaleHeaderId").toString();
        System.out.println("Header Id -->" + headerId1);
        
        System.out.println("-------CalculateTotQty_TotVal -------->");
        
        String status =null;
        String stmt =
        "BEGIN XX_SALES_CONTRACT_PKG.SC_TOT_VAL_QTY_CALC (:1); end;";

        System.out.println("level 1.3 -------->");

        CallableStatement cs = appM.getDBTransaction().createCallableStatement(stmt, 1);
        try {
        // cs.registerOutParameter(1, OracleTypes.VARCHAR);
        cs.setInt(1, Integer.parseInt(headerId1));
        // cs.setInt(2, 'A');
        cs.execute();
        // status = cs.getString(1);
        cs.close();

        } catch (Exception e) {
        status = e.getMessage();
        }

        System.out.println("level 1.4 -------->");

        // getImpSaleContrHeader1().executeQuery();
        refreshQueryKeepingCurrentRow();
        System.out.println("level 1.5 -------->");
    }

    public void ExportLCValueChange(ValueChangeEvent valueChangeEvent) {
        // Add event code here...
        System.out.println("Export LC Value "+valueChangeEvent.getNewValue());
        FacesContext fctx = FacesContext.getCurrentInstance();
        ExternalContext ectx = fctx.getExternalContext();
        HttpSession userSession = (HttpSession) ectx.getSession(false);
        userSession.setAttribute("ExportLcFlag", valueChangeEvent.getNewValue());
    }

    public void setExportLCTab(RichShowDetailItem exportLCTab) {
        this.exportLCTab = exportLCTab;
    }

    public RichShowDetailItem getExportLCTab() {
        return exportLCTab;
    }

    public void setLastShipmenDate(RichInputDate lastShipmenDate) {
        this.lastShipmenDate = lastShipmenDate;
    }

    public RichInputDate getLastShipmenDate() {
        return lastShipmenDate;
    }

    public void setContractExpiryDate(RichInputText contractExpiryDate) {
        this.contractExpiryDate = contractExpiryDate;
    }

    public RichInputText getContractExpiryDate() {
        return contractExpiryDate;
    }

    public void setContractBind(RichInputText contractBind) {
        this.contractBind = contractBind;
    }

    public RichInputText getContractBind() {
        return contractBind;
    }

    public void SelectAllAmend(ActionEvent actionEvent) {
        // Add event code here...
        try {
          //  ViewObject vo = appM.getFillAmendVO1();
           ViewObject vo = appM.getFillAmendVO1();
            vo.setRangeSize(1000);
            Row[] rowArray = vo.getAllRowsInRange();
            
            System.out.println("=========== select all ======== ");
            
       //    System.out.println("row length: " + fillBPORowCount.getValue().toString());
        //            vo.setRangeSize(Integer.parseInt(fillBPORowCount.getValue().toString()));
            for (Row newRow : rowArray){
                System.out.println("=========== select all 1 ======== ");
                newRow.setAttribute("CheckBoxAmend", "Y");
                System.out.println("=========== select all 2======== ");
            }
            AdfFacesContext.getCurrentInstance().addPartialTarget(amendTableNew);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void DeSelectAllAmend(ActionEvent actionEvent) {
        // Add event code here...   
        try {
            ViewObject vo = appM.getFillAmendVO1();
            vo.setRangeSize(1000);
            Row[] rowArray = vo.getAllRowsInRange();
            
            System.out.println("=========== Deselect all ======== ");
         //   System.out.println("row length: " + fillBPORowCount.getValue().toString());
        //            vo.setRangeSize(Integer.parseInt(fillBPORowCount.getValue().toString()));
            for (Row newRow : rowArray){
                newRow.setAttribute("CheckBoxAmend", "N");
            }
            AdfFacesContext.getCurrentInstance().addPartialTarget(amendTableNew);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void setAmendTableNew(RichTable amendTableNew) {
        this.amendTableNew = amendTableNew;
    }

    public RichTable getAmendTableNew() {
        return amendTableNew;
    }

    public void setContractQuantity(RichInputText contractQuantity) {
        this.contractQuantity = contractQuantity;
    }

    public RichInputText getContractQuantity() {
        return contractQuantity;
    }


    public void editDialogListenerNew1(DialogEvent dialogEvent) {
        // Add event code here...
        
        if (dialogEvent.getOutcome().name().equals("ok")) {     
          FillBPO1();
          AdfFacesContext.getCurrentInstance().addPartialTarget(amendtable);  
        } else if (dialogEvent.getOutcome().name().equals("cancel")) {          
         ;
        }   
    }
    
    public void FillBPO1() {
        
        ViewObject populatevo = appM.getFillAmendVO1();
        if (populatevo.getRowCount() == 0);
        RowSetIterator it = populatevo.createRowSetIterator("aaa");
        Row r[] = populatevo.getAllRowsInRange();
        for (Row row : r) {
        System.out.println("loop FillBPO1 count");
        try {
        
        System.out.println("loop FillBPO1 count with in try start");
        String flag = row.getAttribute("CheckBoxAmend").toString();
        System.out.println("loop FillBPO1 count with in try end");
        System.out.println("Amend Flag Code -->" + flag);
        if (flag.equals("Y"))
        populateMaterialLines1(row);
        } catch (Exception e)
        {
           ;
           e.printStackTrace();
        }
        }
        it.closeRowSetIterator();
    }
    
    public void populateMaterialLines1(Row poprow) {
        
    System.out.println("============== populateMaterialLines1 =================");

    ViewObject vo = appM.getImpSaleContractAmendVO1();
    
    String BuyerId = getBuyerid();
    
    System.out.println("========= populateMaterialLines1 == BuyerId =========="+BuyerId);
    
    Row linerow = createMaterialLines1();

    linerow.setAttribute("BpoNo",getPopulateValue(poprow, "Bpo"));
    
    linerow.setAttribute("StyleNo",getPopulateValue(poprow, "Style"));
    
    linerow.setAttribute("ItemDescription",getPopulateValue(poprow, "ItemDesc"));
    
    linerow.setAttribute("Quantity",getPopulateValue(poprow, "Quantity"));
    
    linerow.setAttribute("UnitPrice",getPopulateValue(poprow, "Price"));
    
    linerow.setAttribute("TotalValue",getPopulateValue(poprow, "TotalValue"));
    
    linerow.setAttribute("ShipExFactoryDate",getPopulateValue(poprow, "ShipExFacDate"));
    
    linerow.setAttribute("ShipCancelExBdDate",getPopulateValue(poprow, "ShipCancelBdDate"));
    
    linerow.setAttribute("SalesTerm",getPopulateValue(poprow, "SalesTerms"));
    
    linerow.setAttribute("Attribute1",getPopulateValue(poprow, "LineId"));
    
    
 //   linerow.setAttribute("Attribute4",getPopulateValue(poprow, "Classification"));
    
    System.out.println("============== populateMaterialLines1 ========= END ========");
    
    populateBpoLines1(BuyerId);
    
    } //end of populateLines
    

    public void populateBpoLines1(String BuyerID) {

    ViewObject populatevo = appM.getFillAmendVO1();
    
    String BuyerId = getBuyerid();
    
    String BuyerName = getBuyerName();
    
    String Season = getSeason1();
    

     System.out.println(" ==1======== BuyerName ======== "+BuyerName);

     System.out.println(" ==2======== BuyerID ======== "+BuyerID);

     System.out.println(" ==3======== BuyerID ======== "+Season);
    
    System.out.println("========= populateBpoLines1 == BuyerId =========="+BuyerId);

  //  String impSaleHeaderId = this.getImpSaleContrHeader1().getCurrentRow().getAttribute("ImpSaleHeaderId").toString();
      
   String impSaleHeaderId = appM.getImpSaleContrHeaderVO1().getCurrentRow().getAttribute("ImpSaleHeaderId").toString();
     
     
    System.out.println("========= populateBpoLines1 == impSaleHeaderId =========="+impSaleHeaderId);
    
     populatevo.setWhereClause
     ("IMP_SALE_HEADER_ID = "+impSaleHeaderId+" AND BUYER_NAME = '"+BuyerName+"'"+" AND SEASON = '"+Season+"'");
      
//     populatevo.setWhereClause  
//    ("IMP_SALE_HEADER_ID = "+impSaleHeaderId+" AND BuyerId = '"+BuyerId+"'"+" AND SEASON = '"+Season+"'");


     populatevo.executeQuery();

    // System.out.println("============================ BUYER_NAME = '"+BuyerName+"'"+" AND SEASON = '"+Season+"'");

    if (populatevo.getRowCount() == 0) {

    // System.out.println("======================== populatevo.getRowCount() == 0 ");

    populatevo.setWhereClause(null);
    populatevo.setWhereClause("CUST_ID = " + BuyerID);
    populatevo.executeQuery();

    System.out.println("======================== CUST_ID = "+ BuyerID);
    }

 } //end of populateOrderLines method
    
    
    public Row createMaterialLines1() {

  //  ViewObject vo = getImpSaleContractAmend1();
    System.out.println("============== populateMaterialLines1 ========1=========");
    ViewObject vo = appM.getImpSaleContractAmendVO1();
    System.out.println("============== populateMaterialLines1 ========2=========");
    Row row = vo.createRow();
    System.out.println("============== populateMaterialLines1 ========3=========");
    vo.insertRow(row);
    System.out.println("============== populateMaterialLines1 ========4=========");
    row.setNewRowState(Row.STATUS_INITIALIZED);
    System.out.println("============== populateMaterialLines1 ========5=========");
    return row;
    
    } //end of createHeader

    /* End For Amend */

    public void setAmendtable(RichTable amendtable) {
        this.amendtable = amendtable;
    }

    public RichTable getAmendtable() {
        return amendtable;
    }
     
    public String getStyleNo(){
            System.out.println("=========== Style GetStyleNo ========");
            String style_no=null;
            ViewObject vo = appM.getImpSaleContrLinesVO1();
            style_no=vo.getCurrentRow().getAttribute("StyleNo").toString();
            return style_no;
        }
    
    public String getHeaderNo(){
            System.out.println("=========== Style GetStyleNo ========");
            String header_no=null;
            ViewObject vo = appM.getImpSaleContrLinesVO1();
            header_no=vo.getCurrentRow().getAttribute("ImpSaleHeaderId").toString();
            return header_no;
        }
     
    public void StyleWiseQtyCalu(PopupFetchEvent popupFetchEvent) {
        // Add event code here...
        
        System.out.println("=========== Popup fatch lishner ========");
        String style_no=getStyleNo();
        String header_no=getHeaderNo();
    
        ViewObject vo = appM.getStyleWiseQtyCalVo1();
        vo.setNamedWhereClauseParam("P_STYLE_NO", style_no);
        vo.setNamedWhereClauseParam("P_HEADER_ID", header_no);
        vo.executeQuery();
//        System.out.println("New query: " +vo.getQuery());
//        System.out.println("=========== Popup style_no lishner ========"+style_no);
//        System.out.println("=========== Popup header_no lishner ========"+header_no);
        AdfFacesContext.getCurrentInstance().addPartialTarget(styleWiseQtyCalu);
    }

    public void setStyleWiseQtyCalu(RichTable styleWiseQtyCalu) {
        this.styleWiseQtyCalu = styleWiseQtyCalu;
    }

    public RichTable getStyleWiseQtyCalu() {
        return styleWiseQtyCalu;
    }
}
