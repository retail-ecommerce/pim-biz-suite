
package com.terapico.pim.platform;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.math.BigDecimal;
import com.terapico.caf.DateTime;
import com.terapico.pim.BaseEntity;
import com.terapico.pim.SmartList;
import com.terapico.pim.KeyValuePair;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.terapico.pim.site.Site;
import com.terapico.pim.catalog.Catalog;
import com.terapico.pim.brand.Brand;

@JsonSerialize(using = PlatformSerializer.class)
public class Platform extends BaseEntity implements  java.io.Serializable{

	
	public static final String ID_PROPERTY                    = "id"                ;
	public static final String NAME_PROPERTY                  = "name"              ;
	public static final String INTRODUCTION_PROPERTY          = "introduction"      ;
	public static final String CURRENT_VERSION_PROPERTY       = "currentVersion"    ;
	public static final String VERSION_PROPERTY               = "version"           ;

	public static final String SITE_LIST                                = "siteList"          ;
	public static final String CATALOG_LIST                             = "catalogList"       ;
	public static final String BRAND_LIST                               = "brandList"         ;

	public static final String INTERNAL_TYPE="Platform";
	public String getInternalType(){
		return INTERNAL_TYPE;
	}
	
	public String getDisplayName(){
	
		String displayName = getName();
		if(displayName!=null){
			return displayName;
		}
		
		return super.getDisplayName();
		
	}

	private static final long serialVersionUID = 1L;
	

	protected		String              	mId                 ;
	protected		String              	mName               ;
	protected		String              	mIntroduction       ;
	protected		String              	mCurrentVersion     ;
	protected		int                 	mVersion            ;
	
	
	protected		SmartList<Site>     	mSiteList           ;
	protected		SmartList<Catalog>  	mCatalogList        ;
	protected		SmartList<Brand>    	mBrandList          ;
	
		
	public 	Platform(){
		//lazy load for all the properties
	}
	//disconnect from all, 中文就是一了百了，跟所有一切尘世断绝往来藏身于茫茫数据海洋
	public 	void clearFromAll(){

		this.changed = true;
	}
	
	public 	Platform(String name, String introduction, String currentVersion)
	{
		setName(name);
		setIntroduction(introduction);
		setCurrentVersion(currentVersion);

		this.mSiteList = new SmartList<Site>();
		this.mCatalogList = new SmartList<Catalog>();
		this.mBrandList = new SmartList<Brand>();	
	}
	
	//Support for changing the property
	
	public void changeProperty(String property, String newValueExpr) {
     	
		if(NAME_PROPERTY.equals(property)){
			changeNameProperty(newValueExpr);
		}
		if(INTRODUCTION_PROPERTY.equals(property)){
			changeIntroductionProperty(newValueExpr);
		}
		if(CURRENT_VERSION_PROPERTY.equals(property)){
			changeCurrentVersionProperty(newValueExpr);
		}

      
	}
    
    
	protected void changeNameProperty(String newValueExpr){
		String oldValue = getName();
		String newValue = parseString(newValueExpr);
		if(equalsString(oldValue , newValue)){
			return;//they can be both null, or exact the same object, this is much faster than equals function
		}
		//they are surely different each other
		updateName(newValue);
		this.onChangeProperty(NAME_PROPERTY, oldValue, newValue);
		return;
  
	}
			
			
			
	protected void changeIntroductionProperty(String newValueExpr){
		String oldValue = getIntroduction();
		String newValue = parseString(newValueExpr);
		if(equalsString(oldValue , newValue)){
			return;//they can be both null, or exact the same object, this is much faster than equals function
		}
		//they are surely different each other
		updateIntroduction(newValue);
		this.onChangeProperty(INTRODUCTION_PROPERTY, oldValue, newValue);
		return;
  
	}
			
			
			
	protected void changeCurrentVersionProperty(String newValueExpr){
		String oldValue = getCurrentVersion();
		String newValue = parseString(newValueExpr);
		if(equalsString(oldValue , newValue)){
			return;//they can be both null, or exact the same object, this is much faster than equals function
		}
		//they are surely different each other
		updateCurrentVersion(newValue);
		this.onChangeProperty(CURRENT_VERSION_PROPERTY, oldValue, newValue);
		return;
  
	}
			
			
			


	
	
	
	public void setId(String id){
		this.mId = trimString(id);;
	}
	public String getId(){
		return this.mId;
	}
	public Platform updateId(String id){
		this.mId = trimString(id);;
		this.changed = true;
		return this;
	}
	
	
	public void setName(String name){
		this.mName = trimString(name);;
	}
	public String getName(){
		return this.mName;
	}
	public Platform updateName(String name){
		this.mName = trimString(name);;
		this.changed = true;
		return this;
	}
	
	
	public void setIntroduction(String introduction){
		this.mIntroduction = trimString(introduction);;
	}
	public String getIntroduction(){
		return this.mIntroduction;
	}
	public Platform updateIntroduction(String introduction){
		this.mIntroduction = trimString(introduction);;
		this.changed = true;
		return this;
	}
	
	
	public void setCurrentVersion(String currentVersion){
		this.mCurrentVersion = trimString(currentVersion);;
	}
	public String getCurrentVersion(){
		return this.mCurrentVersion;
	}
	public Platform updateCurrentVersion(String currentVersion){
		this.mCurrentVersion = trimString(currentVersion);;
		this.changed = true;
		return this;
	}
	
	
	public void setVersion(int version){
		this.mVersion = version;;
	}
	public int getVersion(){
		return this.mVersion;
	}
	public Platform updateVersion(int version){
		this.mVersion = version;;
		this.changed = true;
		return this;
	}
	
	

	public  SmartList<Site> getSiteList(){
		if(this.mSiteList == null){
			this.mSiteList = new SmartList<Site>();
			this.mSiteList.setListInternalName (SITE_LIST );
			//有名字，便于做权限控制
		}
		
		return this.mSiteList;	
	}
	public  void setSiteList(SmartList<Site> siteList){
		for( Site site:siteList){
			site.setPlatform(this);
		}

		this.mSiteList = siteList;
		this.mSiteList.setListInternalName (SITE_LIST );
		
	}
	
	public  void addSite(Site site){
		site.setPlatform(this);
		getSiteList().add(site);
	}
	public  void addSiteList(SmartList<Site> siteList){
		for( Site site:siteList){
			site.setPlatform(this);
		}
		getSiteList().addAll(siteList);
	}
	
	public  Site removeSite(Site siteIndex){
		
		int index = getSiteList().indexOf(siteIndex);
        if(index < 0){
        	String message = "Site("+siteIndex.getId()+") with version='"+siteIndex.getVersion()+"' NOT found!";
            throw new IllegalStateException(message);
        }
        Site site = getSiteList().get(index);        
        // site.clearPlatform(); //disconnect with Platform
        site.clearFromAll(); //disconnect with Platform
		
		boolean result = getSiteList().planToRemove(site);
        if(!result){
        	String message = "Site("+siteIndex.getId()+") with version='"+siteIndex.getVersion()+"' NOT found!";
            throw new IllegalStateException(message);
        }
        return site;
        
	
	}
	//断舍离
	public  void breakWithSite(Site site){
		
		if(site == null){
			return;
		}
		site.setPlatform(null);
		//getSiteList().remove();
	
	}
	
	public  boolean hasSite(Site site){
	
		return getSiteList().contains(site);
  
	}
	
	public void copySiteFrom(Site site) {

		Site siteInList = findTheSite(site);
		Site newSite = new Site();
		siteInList.copyTo(newSite);
		newSite.setVersion(0);//will trigger copy
		getSiteList().add(newSite);
		addItemToFlexiableObject(COPIED_CHILD, newSite);
	}
	
	public  Site findTheSite(Site site){
		
		int index =  getSiteList().indexOf(site);
		//The input parameter must have the same id and version number.
		if(index < 0){
 			String message = "Site("+site.getId()+") with version='"+site.getVersion()+"' NOT found!";
			throw new IllegalStateException(message);
		}
		
		return  getSiteList().get(index);
		//Performance issue when using LinkedList, but it is almost an ArrayList for sure!
	}
	
	public  void cleanUpSiteList(){
		getSiteList().clear();
	}
	
	
	


	public  SmartList<Catalog> getCatalogList(){
		if(this.mCatalogList == null){
			this.mCatalogList = new SmartList<Catalog>();
			this.mCatalogList.setListInternalName (CATALOG_LIST );
			//有名字，便于做权限控制
		}
		
		return this.mCatalogList;	
	}
	public  void setCatalogList(SmartList<Catalog> catalogList){
		for( Catalog catalog:catalogList){
			catalog.setPlatform(this);
		}

		this.mCatalogList = catalogList;
		this.mCatalogList.setListInternalName (CATALOG_LIST );
		
	}
	
	public  void addCatalog(Catalog catalog){
		catalog.setPlatform(this);
		getCatalogList().add(catalog);
	}
	public  void addCatalogList(SmartList<Catalog> catalogList){
		for( Catalog catalog:catalogList){
			catalog.setPlatform(this);
		}
		getCatalogList().addAll(catalogList);
	}
	
	public  Catalog removeCatalog(Catalog catalogIndex){
		
		int index = getCatalogList().indexOf(catalogIndex);
        if(index < 0){
        	String message = "Catalog("+catalogIndex.getId()+") with version='"+catalogIndex.getVersion()+"' NOT found!";
            throw new IllegalStateException(message);
        }
        Catalog catalog = getCatalogList().get(index);        
        // catalog.clearPlatform(); //disconnect with Platform
        catalog.clearFromAll(); //disconnect with Platform
		
		boolean result = getCatalogList().planToRemove(catalog);
        if(!result){
        	String message = "Catalog("+catalogIndex.getId()+") with version='"+catalogIndex.getVersion()+"' NOT found!";
            throw new IllegalStateException(message);
        }
        return catalog;
        
	
	}
	//断舍离
	public  void breakWithCatalog(Catalog catalog){
		
		if(catalog == null){
			return;
		}
		catalog.setPlatform(null);
		//getCatalogList().remove();
	
	}
	
	public  boolean hasCatalog(Catalog catalog){
	
		return getCatalogList().contains(catalog);
  
	}
	
	public void copyCatalogFrom(Catalog catalog) {

		Catalog catalogInList = findTheCatalog(catalog);
		Catalog newCatalog = new Catalog();
		catalogInList.copyTo(newCatalog);
		newCatalog.setVersion(0);//will trigger copy
		getCatalogList().add(newCatalog);
		addItemToFlexiableObject(COPIED_CHILD, newCatalog);
	}
	
	public  Catalog findTheCatalog(Catalog catalog){
		
		int index =  getCatalogList().indexOf(catalog);
		//The input parameter must have the same id and version number.
		if(index < 0){
 			String message = "Catalog("+catalog.getId()+") with version='"+catalog.getVersion()+"' NOT found!";
			throw new IllegalStateException(message);
		}
		
		return  getCatalogList().get(index);
		//Performance issue when using LinkedList, but it is almost an ArrayList for sure!
	}
	
	public  void cleanUpCatalogList(){
		getCatalogList().clear();
	}
	
	
	


	public  SmartList<Brand> getBrandList(){
		if(this.mBrandList == null){
			this.mBrandList = new SmartList<Brand>();
			this.mBrandList.setListInternalName (BRAND_LIST );
			//有名字，便于做权限控制
		}
		
		return this.mBrandList;	
	}
	public  void setBrandList(SmartList<Brand> brandList){
		for( Brand brand:brandList){
			brand.setPlatform(this);
		}

		this.mBrandList = brandList;
		this.mBrandList.setListInternalName (BRAND_LIST );
		
	}
	
	public  void addBrand(Brand brand){
		brand.setPlatform(this);
		getBrandList().add(brand);
	}
	public  void addBrandList(SmartList<Brand> brandList){
		for( Brand brand:brandList){
			brand.setPlatform(this);
		}
		getBrandList().addAll(brandList);
	}
	
	public  Brand removeBrand(Brand brandIndex){
		
		int index = getBrandList().indexOf(brandIndex);
        if(index < 0){
        	String message = "Brand("+brandIndex.getId()+") with version='"+brandIndex.getVersion()+"' NOT found!";
            throw new IllegalStateException(message);
        }
        Brand brand = getBrandList().get(index);        
        // brand.clearPlatform(); //disconnect with Platform
        brand.clearFromAll(); //disconnect with Platform
		
		boolean result = getBrandList().planToRemove(brand);
        if(!result){
        	String message = "Brand("+brandIndex.getId()+") with version='"+brandIndex.getVersion()+"' NOT found!";
            throw new IllegalStateException(message);
        }
        return brand;
        
	
	}
	//断舍离
	public  void breakWithBrand(Brand brand){
		
		if(brand == null){
			return;
		}
		brand.setPlatform(null);
		//getBrandList().remove();
	
	}
	
	public  boolean hasBrand(Brand brand){
	
		return getBrandList().contains(brand);
  
	}
	
	public void copyBrandFrom(Brand brand) {

		Brand brandInList = findTheBrand(brand);
		Brand newBrand = new Brand();
		brandInList.copyTo(newBrand);
		newBrand.setVersion(0);//will trigger copy
		getBrandList().add(newBrand);
		addItemToFlexiableObject(COPIED_CHILD, newBrand);
	}
	
	public  Brand findTheBrand(Brand brand){
		
		int index =  getBrandList().indexOf(brand);
		//The input parameter must have the same id and version number.
		if(index < 0){
 			String message = "Brand("+brand.getId()+") with version='"+brand.getVersion()+"' NOT found!";
			throw new IllegalStateException(message);
		}
		
		return  getBrandList().get(index);
		//Performance issue when using LinkedList, but it is almost an ArrayList for sure!
	}
	
	public  void cleanUpBrandList(){
		getBrandList().clear();
	}
	
	
	


	public void collectRefercences(BaseEntity owner, List<BaseEntity> entityList, String internalType){


		
	}
	
	public List<BaseEntity>  collectRefercencesFromLists(String internalType){
		
		List<BaseEntity> entityList = new ArrayList<BaseEntity>();
		collectFromList(this, entityList, getSiteList(), internalType);
		collectFromList(this, entityList, getCatalogList(), internalType);
		collectFromList(this, entityList, getBrandList(), internalType);

		return entityList;
	}
	
	public  List<SmartList<?>> getAllRelatedLists() {
		List<SmartList<?>> listOfList = new ArrayList<SmartList<?>>();
		
		listOfList.add( getSiteList());
		listOfList.add( getCatalogList());
		listOfList.add( getBrandList());
			

		return listOfList;
	}

	
	public List<KeyValuePair> keyValuePairOf(){
		List<KeyValuePair> result =  super.keyValuePairOf();

		appendKeyValuePair(result, ID_PROPERTY, getId());
		appendKeyValuePair(result, NAME_PROPERTY, getName());
		appendKeyValuePair(result, INTRODUCTION_PROPERTY, getIntroduction());
		appendKeyValuePair(result, CURRENT_VERSION_PROPERTY, getCurrentVersion());
		appendKeyValuePair(result, VERSION_PROPERTY, getVersion());
		appendKeyValuePair(result, SITE_LIST, getSiteList());
		if(!getSiteList().isEmpty()){
			appendKeyValuePair(result, "siteCount", getSiteList().getTotalCount());
			appendKeyValuePair(result, "siteCurrentPageNumber", getSiteList().getCurrentPageNumber());
		}
		appendKeyValuePair(result, CATALOG_LIST, getCatalogList());
		if(!getCatalogList().isEmpty()){
			appendKeyValuePair(result, "catalogCount", getCatalogList().getTotalCount());
			appendKeyValuePair(result, "catalogCurrentPageNumber", getCatalogList().getCurrentPageNumber());
		}
		appendKeyValuePair(result, BRAND_LIST, getBrandList());
		if(!getBrandList().isEmpty()){
			appendKeyValuePair(result, "brandCount", getBrandList().getTotalCount());
			appendKeyValuePair(result, "brandCurrentPageNumber", getBrandList().getCurrentPageNumber());
		}

		
		return result;
	}
	
	
	public BaseEntity copyTo(BaseEntity baseDest){
		
		
		if(baseDest instanceof Platform){
		
		
			Platform dest =(Platform)baseDest;
		
			dest.setId(getId());
			dest.setName(getName());
			dest.setIntroduction(getIntroduction());
			dest.setCurrentVersion(getCurrentVersion());
			dest.setVersion(getVersion());
			dest.setSiteList(getSiteList());
			dest.setCatalogList(getCatalogList());
			dest.setBrandList(getBrandList());

		}
		super.copyTo(baseDest);
		return baseDest;
	}
	
	public String toString(){
		StringBuilder stringBuilder=new StringBuilder(128);

		stringBuilder.append("Platform{");
		stringBuilder.append("\tid='"+getId()+"';");
		stringBuilder.append("\tname='"+getName()+"';");
		stringBuilder.append("\tintroduction='"+getIntroduction()+"';");
		stringBuilder.append("\tcurrentVersion='"+getCurrentVersion()+"';");
		stringBuilder.append("\tversion='"+getVersion()+"';");
		stringBuilder.append("}");

		return stringBuilder.toString();
	}
	
	//provide number calculation function
	

}

