package model.entity;

import oracle.jbo.AttributeList;
import oracle.jbo.Key;
import oracle.jbo.domain.Date;
import oracle.jbo.domain.Number;
import oracle.jbo.server.AttributeDefImpl;
import oracle.jbo.server.EntityDefImpl;
import oracle.jbo.server.EntityImpl;
// ---------------------------------------------------------------------
// ---    File generated by Oracle ADF Business Components Design Time.
// ---    Fri Sep 04 23:15:34 BDT 2020
// ---    Custom code may be added to this class.
// ---    Warning: Do not modify method signatures of generated methods.
// ---------------------------------------------------------------------
public class ImpSaleContrLinesEOImpl extends EntityImpl {
    private static EntityDefImpl mDefinitionObject;

    /**
     * AttributesEnum: generated enum for identifying attributes and accessors. Do not modify.
     */
    public enum AttributesEnum {
        ImpSaleLineId {
            public Object get(ImpSaleContrLinesEOImpl obj) {
                return obj.getImpSaleLineId();
            }

            public void put(ImpSaleContrLinesEOImpl obj, Object value) {
                obj.setImpSaleLineId((Number)value);
            }
        }
        ,
        ImpSaleHeaderId {
            public Object get(ImpSaleContrLinesEOImpl obj) {
                return obj.getImpSaleHeaderId();
            }

            public void put(ImpSaleContrLinesEOImpl obj, Object value) {
                obj.setImpSaleHeaderId((Number)value);
            }
        }
        ,
        StyleNo {
            public Object get(ImpSaleContrLinesEOImpl obj) {
                return obj.getStyleNo();
            }

            public void put(ImpSaleContrLinesEOImpl obj, Object value) {
                obj.setStyleNo((String)value);
            }
        }
        ,
        BpoNo {
            public Object get(ImpSaleContrLinesEOImpl obj) {
                return obj.getBpoNo();
            }

            public void put(ImpSaleContrLinesEOImpl obj, Object value) {
                obj.setBpoNo((String)value);
            }
        }
        ,
        ItemDescription {
            public Object get(ImpSaleContrLinesEOImpl obj) {
                return obj.getItemDescription();
            }

            public void put(ImpSaleContrLinesEOImpl obj, Object value) {
                obj.setItemDescription((String)value);
            }
        }
        ,
        Quantity {
            public Object get(ImpSaleContrLinesEOImpl obj) {
                return obj.getQuantity();
            }

            public void put(ImpSaleContrLinesEOImpl obj, Object value) {
                obj.setQuantity((Number)value);
            }
        }
        ,
        UnitPrice {
            public Object get(ImpSaleContrLinesEOImpl obj) {
                return obj.getUnitPrice();
            }

            public void put(ImpSaleContrLinesEOImpl obj, Object value) {
                obj.setUnitPrice((Number)value);
            }
        }
        ,
        TotalValue {
            public Object get(ImpSaleContrLinesEOImpl obj) {
                return obj.getTotalValue();
            }

            public void put(ImpSaleContrLinesEOImpl obj, Object value) {
                obj.setTotalValue((Number)value);
            }
        }
        ,
        ShipExFactoryDate {
            public Object get(ImpSaleContrLinesEOImpl obj) {
                return obj.getShipExFactoryDate();
            }

            public void put(ImpSaleContrLinesEOImpl obj, Object value) {
                obj.setShipExFactoryDate((Date)value);
            }
        }
        ,
        ShipCancelExBdDate {
            public Object get(ImpSaleContrLinesEOImpl obj) {
                return obj.getShipCancelExBdDate();
            }

            public void put(ImpSaleContrLinesEOImpl obj, Object value) {
                obj.setShipCancelExBdDate((Date)value);
            }
        }
        ,
        SalesTerm {
            public Object get(ImpSaleContrLinesEOImpl obj) {
                return obj.getSalesTerm();
            }

            public void put(ImpSaleContrLinesEOImpl obj, Object value) {
                obj.setSalesTerm((String)value);
            }
        }
        ,
        Status {
            public Object get(ImpSaleContrLinesEOImpl obj) {
                return obj.getStatus();
            }

            public void put(ImpSaleContrLinesEOImpl obj, Object value) {
                obj.setStatus((String)value);
            }
        }
        ,
        LastUpdateLogin {
            public Object get(ImpSaleContrLinesEOImpl obj) {
                return obj.getLastUpdateLogin();
            }

            public void put(ImpSaleContrLinesEOImpl obj, Object value) {
                obj.setLastUpdateLogin((Number)value);
            }
        }
        ,
        LastUpdateDate {
            public Object get(ImpSaleContrLinesEOImpl obj) {
                return obj.getLastUpdateDate();
            }

            public void put(ImpSaleContrLinesEOImpl obj, Object value) {
                obj.setLastUpdateDate((Date)value);
            }
        }
        ,
        LastUpdatedBy {
            public Object get(ImpSaleContrLinesEOImpl obj) {
                return obj.getLastUpdatedBy();
            }

            public void put(ImpSaleContrLinesEOImpl obj, Object value) {
                obj.setLastUpdatedBy((Number)value);
            }
        }
        ,
        CreationDate {
            public Object get(ImpSaleContrLinesEOImpl obj) {
                return obj.getCreationDate();
            }

            public void put(ImpSaleContrLinesEOImpl obj, Object value) {
                obj.setCreationDate((Date)value);
            }
        }
        ,
        CreatedBy {
            public Object get(ImpSaleContrLinesEOImpl obj) {
                return obj.getCreatedBy();
            }

            public void put(ImpSaleContrLinesEOImpl obj, Object value) {
                obj.setCreatedBy((Number)value);
            }
        }
        ,
        Attribute1 {
            public Object get(ImpSaleContrLinesEOImpl obj) {
                return obj.getAttribute1();
            }

            public void put(ImpSaleContrLinesEOImpl obj, Object value) {
                obj.setAttribute1((String)value);
            }
        }
        ,
        Attribute2 {
            public Object get(ImpSaleContrLinesEOImpl obj) {
                return obj.getAttribute2();
            }

            public void put(ImpSaleContrLinesEOImpl obj, Object value) {
                obj.setAttribute2((String)value);
            }
        }
        ,
        LastPrice {
            public Object get(ImpSaleContrLinesEOImpl obj) {
                return obj.getLastPrice();
            }

            public void put(ImpSaleContrLinesEOImpl obj, Object value) {
                obj.setLastPrice((Number)value);
            }
        }
        ,
        LastTotalPrice {
            public Object get(ImpSaleContrLinesEOImpl obj) {
                return obj.getLastTotalPrice();
            }

            public void put(ImpSaleContrLinesEOImpl obj, Object value) {
                obj.setLastTotalPrice((Number)value);
            }
        }
        ,
        LastQty {
            public Object get(ImpSaleContrLinesEOImpl obj) {
                return obj.getLastQty();
            }

            public void put(ImpSaleContrLinesEOImpl obj, Object value) {
                obj.setLastQty((Number)value);
            }
        }
        ,
        BpoId {
            public Object get(ImpSaleContrLinesEOImpl obj) {
                return obj.getBpoId();
            }

            public void put(ImpSaleContrLinesEOImpl obj, Object value) {
                obj.setBpoId((String)value);
            }
        }
        ,
        OldBpo {
            public Object get(ImpSaleContrLinesEOImpl obj) {
                return obj.getOldBpo();
            }

            public void put(ImpSaleContrLinesEOImpl obj, Object value) {
                obj.setOldBpo((String)value);
            }
        }
        ,
        ImpSaleContrHeaderEO {
            public Object get(ImpSaleContrLinesEOImpl obj) {
                return obj.getImpSaleContrHeaderEO();
            }

            public void put(ImpSaleContrLinesEOImpl obj, Object value) {
                obj.setImpSaleContrHeaderEO((ImpSaleContrHeaderEOImpl)value);
            }
        }
        ;
        private static AttributesEnum[] vals = null;
        private static int firstIndex = 0;

        public abstract Object get(ImpSaleContrLinesEOImpl object);

        public abstract void put(ImpSaleContrLinesEOImpl object, Object value);

        public int index() {
            return AttributesEnum.firstIndex() + ordinal();
        }

        public static int firstIndex() {
            return firstIndex;
        }

        public static int count() {
            return AttributesEnum.firstIndex() + AttributesEnum.staticValues().length;
        }

        public static AttributesEnum[] staticValues() {
            if (vals == null) {
                vals = AttributesEnum.values();
            }
            return vals;
        }
    }


    public static final int IMPSALELINEID = AttributesEnum.ImpSaleLineId.index();
    public static final int IMPSALEHEADERID = AttributesEnum.ImpSaleHeaderId.index();
    public static final int STYLENO = AttributesEnum.StyleNo.index();
    public static final int BPONO = AttributesEnum.BpoNo.index();
    public static final int ITEMDESCRIPTION = AttributesEnum.ItemDescription.index();
    public static final int QUANTITY = AttributesEnum.Quantity.index();
    public static final int UNITPRICE = AttributesEnum.UnitPrice.index();
    public static final int TOTALVALUE = AttributesEnum.TotalValue.index();
    public static final int SHIPEXFACTORYDATE = AttributesEnum.ShipExFactoryDate.index();
    public static final int SHIPCANCELEXBDDATE = AttributesEnum.ShipCancelExBdDate.index();
    public static final int SALESTERM = AttributesEnum.SalesTerm.index();
    public static final int STATUS = AttributesEnum.Status.index();
    public static final int LASTUPDATELOGIN = AttributesEnum.LastUpdateLogin.index();
    public static final int LASTUPDATEDATE = AttributesEnum.LastUpdateDate.index();
    public static final int LASTUPDATEDBY = AttributesEnum.LastUpdatedBy.index();
    public static final int CREATIONDATE = AttributesEnum.CreationDate.index();
    public static final int CREATEDBY = AttributesEnum.CreatedBy.index();
    public static final int ATTRIBUTE1 = AttributesEnum.Attribute1.index();
    public static final int ATTRIBUTE2 = AttributesEnum.Attribute2.index();
    public static final int LASTPRICE = AttributesEnum.LastPrice.index();
    public static final int LASTTOTALPRICE = AttributesEnum.LastTotalPrice.index();
    public static final int LASTQTY = AttributesEnum.LastQty.index();
    public static final int BPOID = AttributesEnum.BpoId.index();
    public static final int OLDBPO = AttributesEnum.OldBpo.index();
    public static final int IMPSALECONTRHEADEREO = AttributesEnum.ImpSaleContrHeaderEO.index();

    /**
     * This is the default constructor (do not remove).
     */
    public ImpSaleContrLinesEOImpl() {
    }


    /**
     * @return the definition object for this instance class.
     */
    public static synchronized EntityDefImpl getDefinitionObject() {
        if (mDefinitionObject == null) {
            mDefinitionObject = EntityDefImpl.findDefObject("model.entity.ImpSaleContrLinesEO");
        }
        return mDefinitionObject;
    }

    /**
     * Gets the attribute value for ImpSaleLineId, using the alias name ImpSaleLineId.
     * @return the ImpSaleLineId
     */
    public Number getImpSaleLineId() {
        return (Number)getAttributeInternal(IMPSALELINEID);
    }

    /**
     * Sets <code>value</code> as the attribute value for ImpSaleLineId.
     * @param value value to set the ImpSaleLineId
     */
    public void setImpSaleLineId(Number value) {
        setAttributeInternal(IMPSALELINEID, value);
    }

    /**
     * Gets the attribute value for ImpSaleHeaderId, using the alias name ImpSaleHeaderId.
     * @return the ImpSaleHeaderId
     */
    public Number getImpSaleHeaderId() {
        return (Number)getAttributeInternal(IMPSALEHEADERID);
    }

    /**
     * Sets <code>value</code> as the attribute value for ImpSaleHeaderId.
     * @param value value to set the ImpSaleHeaderId
     */
    public void setImpSaleHeaderId(Number value) {
        setAttributeInternal(IMPSALEHEADERID, value);
    }

    /**
     * Gets the attribute value for StyleNo, using the alias name StyleNo.
     * @return the StyleNo
     */
    public String getStyleNo() {
        return (String)getAttributeInternal(STYLENO);
    }

    /**
     * Sets <code>value</code> as the attribute value for StyleNo.
     * @param value value to set the StyleNo
     */
    public void setStyleNo(String value) {
        setAttributeInternal(STYLENO, value);
    }

    /**
     * Gets the attribute value for BpoNo, using the alias name BpoNo.
     * @return the BpoNo
     */
    public String getBpoNo() {
        return (String)getAttributeInternal(BPONO);
    }

    /**
     * Sets <code>value</code> as the attribute value for BpoNo.
     * @param value value to set the BpoNo
     */
    public void setBpoNo(String value) {
        setAttributeInternal(BPONO, value);
    }

    /**
     * Gets the attribute value for ItemDescription, using the alias name ItemDescription.
     * @return the ItemDescription
     */
    public String getItemDescription() {
        return (String)getAttributeInternal(ITEMDESCRIPTION);
    }

    /**
     * Sets <code>value</code> as the attribute value for ItemDescription.
     * @param value value to set the ItemDescription
     */
    public void setItemDescription(String value) {
        setAttributeInternal(ITEMDESCRIPTION, value);
    }

    /**
     * Gets the attribute value for Quantity, using the alias name Quantity.
     * @return the Quantity
     */
    public Number getQuantity() {
        return (Number)getAttributeInternal(QUANTITY);
    }

    /**
     * Sets <code>value</code> as the attribute value for Quantity.
     * @param value value to set the Quantity
     */
    public void setQuantity(Number value) {
        setAttributeInternal(QUANTITY, value);
    }

    /**
     * Gets the attribute value for UnitPrice, using the alias name UnitPrice.
     * @return the UnitPrice
     */
    public Number getUnitPrice() {
        return (Number)getAttributeInternal(UNITPRICE);
    }

    /**
     * Sets <code>value</code> as the attribute value for UnitPrice.
     * @param value value to set the UnitPrice
     */
    public void setUnitPrice(Number value) {
        setAttributeInternal(UNITPRICE, value);
    }

    /**
     * Gets the attribute value for TotalValue, using the alias name TotalValue.
     * @return the TotalValue
     */
    public Number getTotalValue() {
        return (Number)getAttributeInternal(TOTALVALUE);
    }

    /**
     * Sets <code>value</code> as the attribute value for TotalValue.
     * @param value value to set the TotalValue
     */
    public void setTotalValue(Number value) {
        setAttributeInternal(TOTALVALUE, value);
    }

    /**
     * Gets the attribute value for ShipExFactoryDate, using the alias name ShipExFactoryDate.
     * @return the ShipExFactoryDate
     */
    public Date getShipExFactoryDate() {
        return (Date)getAttributeInternal(SHIPEXFACTORYDATE);
    }

    /**
     * Sets <code>value</code> as the attribute value for ShipExFactoryDate.
     * @param value value to set the ShipExFactoryDate
     */
    public void setShipExFactoryDate(Date value) {
        setAttributeInternal(SHIPEXFACTORYDATE, value);
    }

    /**
     * Gets the attribute value for ShipCancelExBdDate, using the alias name ShipCancelExBdDate.
     * @return the ShipCancelExBdDate
     */
    public Date getShipCancelExBdDate() {
        return (Date)getAttributeInternal(SHIPCANCELEXBDDATE);
    }

    /**
     * Sets <code>value</code> as the attribute value for ShipCancelExBdDate.
     * @param value value to set the ShipCancelExBdDate
     */
    public void setShipCancelExBdDate(Date value) {
        setAttributeInternal(SHIPCANCELEXBDDATE, value);
    }

    /**
     * Gets the attribute value for SalesTerm, using the alias name SalesTerm.
     * @return the SalesTerm
     */
    public String getSalesTerm() {
        return (String)getAttributeInternal(SALESTERM);
    }

    /**
     * Sets <code>value</code> as the attribute value for SalesTerm.
     * @param value value to set the SalesTerm
     */
    public void setSalesTerm(String value) {
        setAttributeInternal(SALESTERM, value);
    }

    /**
     * Gets the attribute value for Status, using the alias name Status.
     * @return the Status
     */
    public String getStatus() {
        return (String)getAttributeInternal(STATUS);
    }

    /**
     * Sets <code>value</code> as the attribute value for Status.
     * @param value value to set the Status
     */
    public void setStatus(String value) {
        setAttributeInternal(STATUS, value);
    }

    /**
     * Gets the attribute value for LastUpdateLogin, using the alias name LastUpdateLogin.
     * @return the LastUpdateLogin
     */
    public Number getLastUpdateLogin() {
        return (Number)getAttributeInternal(LASTUPDATELOGIN);
    }

    /**
     * Sets <code>value</code> as the attribute value for LastUpdateLogin.
     * @param value value to set the LastUpdateLogin
     */
    public void setLastUpdateLogin(Number value) {
        setAttributeInternal(LASTUPDATELOGIN, value);
    }

    /**
     * Gets the attribute value for LastUpdateDate, using the alias name LastUpdateDate.
     * @return the LastUpdateDate
     */
    public Date getLastUpdateDate() {
        return (Date)getAttributeInternal(LASTUPDATEDATE);
    }

    /**
     * Sets <code>value</code> as the attribute value for LastUpdateDate.
     * @param value value to set the LastUpdateDate
     */
    public void setLastUpdateDate(Date value) {
        setAttributeInternal(LASTUPDATEDATE, value);
    }

    /**
     * Gets the attribute value for LastUpdatedBy, using the alias name LastUpdatedBy.
     * @return the LastUpdatedBy
     */
    public Number getLastUpdatedBy() {
        return (Number)getAttributeInternal(LASTUPDATEDBY);
    }

    /**
     * Sets <code>value</code> as the attribute value for LastUpdatedBy.
     * @param value value to set the LastUpdatedBy
     */
    public void setLastUpdatedBy(Number value) {
        setAttributeInternal(LASTUPDATEDBY, value);
    }

    /**
     * Gets the attribute value for CreationDate, using the alias name CreationDate.
     * @return the CreationDate
     */
    public Date getCreationDate() {
        return (Date)getAttributeInternal(CREATIONDATE);
    }

    /**
     * Sets <code>value</code> as the attribute value for CreationDate.
     * @param value value to set the CreationDate
     */
    public void setCreationDate(Date value) {
        setAttributeInternal(CREATIONDATE, value);
    }

    /**
     * Gets the attribute value for CreatedBy, using the alias name CreatedBy.
     * @return the CreatedBy
     */
    public Number getCreatedBy() {
        return (Number)getAttributeInternal(CREATEDBY);
    }

    /**
     * Sets <code>value</code> as the attribute value for CreatedBy.
     * @param value value to set the CreatedBy
     */
    public void setCreatedBy(Number value) {
        setAttributeInternal(CREATEDBY, value);
    }

    /**
     * Gets the attribute value for Attribute1, using the alias name Attribute1.
     * @return the Attribute1
     */
    public String getAttribute1() {
        return (String)getAttributeInternal(ATTRIBUTE1);
    }

    /**
     * Sets <code>value</code> as the attribute value for Attribute1.
     * @param value value to set the Attribute1
     */
    public void setAttribute1(String value) {
        setAttributeInternal(ATTRIBUTE1, value);
    }

    /**
     * Gets the attribute value for Attribute2, using the alias name Attribute2.
     * @return the Attribute2
     */
    public String getAttribute2() {
        return (String)getAttributeInternal(ATTRIBUTE2);
    }

    /**
     * Sets <code>value</code> as the attribute value for Attribute2.
     * @param value value to set the Attribute2
     */
    public void setAttribute2(String value) {
        setAttributeInternal(ATTRIBUTE2, value);
    }

    /**
     * Gets the attribute value for LastPrice, using the alias name LastPrice.
     * @return the LastPrice
     */
    public Number getLastPrice() {
        return (Number)getAttributeInternal(LASTPRICE);
    }

    /**
     * Sets <code>value</code> as the attribute value for LastPrice.
     * @param value value to set the LastPrice
     */
    public void setLastPrice(Number value) {
        setAttributeInternal(LASTPRICE, value);
    }

    /**
     * Gets the attribute value for LastTotalPrice, using the alias name LastTotalPrice.
     * @return the LastTotalPrice
     */
    public Number getLastTotalPrice() {
        return (Number)getAttributeInternal(LASTTOTALPRICE);
    }

    /**
     * Sets <code>value</code> as the attribute value for LastTotalPrice.
     * @param value value to set the LastTotalPrice
     */
    public void setLastTotalPrice(Number value) {
        setAttributeInternal(LASTTOTALPRICE, value);
    }

    /**
     * Gets the attribute value for LastQty, using the alias name LastQty.
     * @return the LastQty
     */
    public Number getLastQty() {
        return (Number)getAttributeInternal(LASTQTY);
    }

    /**
     * Sets <code>value</code> as the attribute value for LastQty.
     * @param value value to set the LastQty
     */
    public void setLastQty(Number value) {
        setAttributeInternal(LASTQTY, value);
    }

    /**
     * Gets the attribute value for BpoId, using the alias name BpoId.
     * @return the BpoId
     */
    public String getBpoId() {
        return (String)getAttributeInternal(BPOID);
    }

    /**
     * Sets <code>value</code> as the attribute value for BpoId.
     * @param value value to set the BpoId
     */
    public void setBpoId(String value) {
        setAttributeInternal(BPOID, value);
    }

    /**
     * Gets the attribute value for OldBpo, using the alias name OldBpo.
     * @return the OldBpo
     */
    public String getOldBpo() {
        return (String)getAttributeInternal(OLDBPO);
    }

    /**
     * Sets <code>value</code> as the attribute value for OldBpo.
     * @param value value to set the OldBpo
     */
    public void setOldBpo(String value) {
        setAttributeInternal(OLDBPO, value);
    }

    /**
     * getAttrInvokeAccessor: generated method. Do not modify.
     * @param index the index identifying the attribute
     * @param attrDef the attribute

     * @return the attribute value
     * @throws Exception
     */
    protected Object getAttrInvokeAccessor(int index,
                                           AttributeDefImpl attrDef) throws Exception {
        if ((index >= AttributesEnum.firstIndex()) && (index < AttributesEnum.count())) {
            return AttributesEnum.staticValues()[index - AttributesEnum.firstIndex()].get(this);
        }
        return super.getAttrInvokeAccessor(index, attrDef);
    }

    /**
     * setAttrInvokeAccessor: generated method. Do not modify.
     * @param index the index identifying the attribute
     * @param value the value to assign to the attribute
     * @param attrDef the attribute

     * @throws Exception
     */
    protected void setAttrInvokeAccessor(int index, Object value,
                                         AttributeDefImpl attrDef) throws Exception {
        if ((index >= AttributesEnum.firstIndex()) && (index < AttributesEnum.count())) {
            AttributesEnum.staticValues()[index - AttributesEnum.firstIndex()].put(this, value);
            return;
        }
        super.setAttrInvokeAccessor(index, value, attrDef);
    }

    /**
     * @return the associated entity oracle.jbo.server.EntityImpl.
     */
    public ImpSaleContrHeaderEOImpl getImpSaleContrHeaderEO() {
        return (ImpSaleContrHeaderEOImpl)getAttributeInternal(IMPSALECONTRHEADEREO);
    }

    /**
     * Sets <code>value</code> as the associated entity oracle.jbo.server.EntityImpl.
     */
    public void setImpSaleContrHeaderEO(ImpSaleContrHeaderEOImpl value) {
        setAttributeInternal(IMPSALECONTRHEADEREO, value);
    }


    /**
     * @param impSaleLineId key constituent

     * @return a Key object based on given key constituents.
     */
    public static Key createPrimaryKey(Number impSaleLineId) {
        return new Key(new Object[]{impSaleLineId});
    }

    /**
     * Add attribute defaulting logic in this method.
     * @param attributeList list of attribute names/values to initialize the row
     */
    protected void create(AttributeList attributeList) {
        super.create(attributeList);
        /* Sequence Generation Code of Lines by PwC */
        oracle.jbo.server.SequenceImpl s = new oracle.jbo.server.SequenceImpl("XX_COM_SALES_CONTRACT_L_SEQ",getDBTransaction());
        oracle.jbo.domain.Number sVal = s.getSequenceNumber();
        setImpSaleLineId(sVal);
        /* End Sequence Generation Code of Lines by PwC */
        
    }
}
