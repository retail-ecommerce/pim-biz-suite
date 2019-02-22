
package com.terapico.pim.profile;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.math.BigDecimal;
import com.terapico.caf.DateTime;
import com.terapico.pim.BaseEntity;
import com.terapico.pim.SmartList;
import com.terapico.pim.KeyValuePair;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.terapico.pim.brandfilter.BrandFilter;
import com.terapico.pim.editorpickproduct.EditorPickProduct;
import com.terapico.pim.pricefilter.PriceFilter;
import com.terapico.pim.categoryfilter.CategoryFilter;
import com.terapico.pim.newproduct.NewProduct;
import com.terapico.pim.topratedproduct.TopRatedProduct;
import com.terapico.pim.recommandproduct.RecommandProduct;
import com.terapico.pim.platform.Platform;

@JsonSerialize(using = ProfileSerializer.class)
public class Profile extends BaseEntity implements  java.io.Serializable{

	
	public static final String ID_PROPERTY                    = "id"                ;
	public static final String NAME_PROPERTY                  = "name"              ;
	public static final String PLATFORM_PROPERTY              = "platform"          ;
	public static final String VERSION_PROPERTY               = "version"           ;

	public static final String BRAND_FILTER_LIST                        = "brandFilterList"   ;
	public static final String PRICE_FILTER_LIST                        = "priceFilterList"   ;
	public static final String CATEGORY_FILTER_LIST                     = "categoryFilterList";
	public static final String NEW_PRODUCT_LIST                         = "newProductList"    ;
	public static final String EDITOR_PICK_PRODUCT_LIST                 = "editorPickProductList";
	public static final String TOP_RATED_PRODUCT_LIST                   = "topRatedProductList";
	public static final String RECOMMAND_PRODUCT_LIST                   = "recommandProductList";

	public static final String INTERNAL_TYPE="Profile";
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
	protected		Platform            	mPlatform           ;
	protected		int                 	mVersion            ;
	
	
	protected		SmartList<BrandFilter>	mBrandFilterList    ;
	protected		SmartList<PriceFilter>	mPriceFilterList    ;
	protected		SmartList<CategoryFilter>	mCategoryFilterList ;
	protected		SmartList<NewProduct>	mNewProductList     ;
	protected		SmartList<EditorPickProduct>	mEditorPickProductList;
	protected		SmartList<TopRatedProduct>	mTopRatedProductList;
	protected		SmartList<RecommandProduct>	mRecommandProductList;
	
		
	public 	Profile(){
		//lazy load for all the properties
	}
	//disconnect from all, 中文就是一了百了，跟所有一切尘世断绝往来藏身于茫茫数据海洋
	public 	void clearFromAll(){
		setPlatform( null );

		this.changed = true;
	}
	
	public 	Profile(String name, Platform platform)
	{
		setName(name);
		setPlatform(platform);

		this.mBrandFilterList = new SmartList<BrandFilter>();
		this.mPriceFilterList = new SmartList<PriceFilter>();
		this.mCategoryFilterList = new SmartList<CategoryFilter>();
		this.mNewProductList = new SmartList<NewProduct>();
		this.mEditorPickProductList = new SmartList<EditorPickProduct>();
		this.mTopRatedProductList = new SmartList<TopRatedProduct>();
		this.mRecommandProductList = new SmartList<RecommandProduct>();	
	}
	
	//Support for changing the property
	
	public void changeProperty(String property, String newValueExpr) {
     	
		if(NAME_PROPERTY.equals(property)){
			changeNameProperty(newValueExpr);
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
			
			
			


	
	
	
	public void setId(String id){
		this.mId = trimString(id);;
	}
	public String getId(){
		return this.mId;
	}
	public Profile updateId(String id){
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
	public Profile updateName(String name){
		this.mName = trimString(name);;
		this.changed = true;
		return this;
	}
	
	
	public void setPlatform(Platform platform){
		this.mPlatform = platform;;
	}
	public Platform getPlatform(){
		return this.mPlatform;
	}
	public Profile updatePlatform(Platform platform){
		this.mPlatform = platform;;
		this.changed = true;
		return this;
	}
	
	
	public void clearPlatform(){
		setPlatform ( null );
		this.changed = true;
	}
	
	public void setVersion(int version){
		this.mVersion = version;;
	}
	public int getVersion(){
		return this.mVersion;
	}
	public Profile updateVersion(int version){
		this.mVersion = version;;
		this.changed = true;
		return this;
	}
	
	

	public  SmartList<BrandFilter> getBrandFilterList(){
		if(this.mBrandFilterList == null){
			this.mBrandFilterList = new SmartList<BrandFilter>();
			this.mBrandFilterList.setListInternalName (BRAND_FILTER_LIST );
			//有名字，便于做权限控制
		}
		
		return this.mBrandFilterList;	
	}
	public  void setBrandFilterList(SmartList<BrandFilter> brandFilterList){
		for( BrandFilter brandFilter:brandFilterList){
			brandFilter.setProfile(this);
		}

		this.mBrandFilterList = brandFilterList;
		this.mBrandFilterList.setListInternalName (BRAND_FILTER_LIST );
		
	}
	
	public  void addBrandFilter(BrandFilter brandFilter){
		brandFilter.setProfile(this);
		getBrandFilterList().add(brandFilter);
	}
	public  void addBrandFilterList(SmartList<BrandFilter> brandFilterList){
		for( BrandFilter brandFilter:brandFilterList){
			brandFilter.setProfile(this);
		}
		getBrandFilterList().addAll(brandFilterList);
	}
	
	public  BrandFilter removeBrandFilter(BrandFilter brandFilterIndex){
		
		int index = getBrandFilterList().indexOf(brandFilterIndex);
        if(index < 0){
        	String message = "BrandFilter("+brandFilterIndex.getId()+") with version='"+brandFilterIndex.getVersion()+"' NOT found!";
            throw new IllegalStateException(message);
        }
        BrandFilter brandFilter = getBrandFilterList().get(index);        
        // brandFilter.clearProfile(); //disconnect with Profile
        brandFilter.clearFromAll(); //disconnect with Profile
		
		boolean result = getBrandFilterList().planToRemove(brandFilter);
        if(!result){
        	String message = "BrandFilter("+brandFilterIndex.getId()+") with version='"+brandFilterIndex.getVersion()+"' NOT found!";
            throw new IllegalStateException(message);
        }
        return brandFilter;
        
	
	}
	//断舍离
	public  void breakWithBrandFilter(BrandFilter brandFilter){
		
		if(brandFilter == null){
			return;
		}
		brandFilter.setProfile(null);
		//getBrandFilterList().remove();
	
	}
	
	public  boolean hasBrandFilter(BrandFilter brandFilter){
	
		return getBrandFilterList().contains(brandFilter);
  
	}
	
	public void copyBrandFilterFrom(BrandFilter brandFilter) {

		BrandFilter brandFilterInList = findTheBrandFilter(brandFilter);
		BrandFilter newBrandFilter = new BrandFilter();
		brandFilterInList.copyTo(newBrandFilter);
		newBrandFilter.setVersion(0);//will trigger copy
		getBrandFilterList().add(newBrandFilter);
		addItemToFlexiableObject(COPIED_CHILD, newBrandFilter);
	}
	
	public  BrandFilter findTheBrandFilter(BrandFilter brandFilter){
		
		int index =  getBrandFilterList().indexOf(brandFilter);
		//The input parameter must have the same id and version number.
		if(index < 0){
 			String message = "BrandFilter("+brandFilter.getId()+") with version='"+brandFilter.getVersion()+"' NOT found!";
			throw new IllegalStateException(message);
		}
		
		return  getBrandFilterList().get(index);
		//Performance issue when using LinkedList, but it is almost an ArrayList for sure!
	}
	
	public  void cleanUpBrandFilterList(){
		getBrandFilterList().clear();
	}
	
	
	


	public  SmartList<PriceFilter> getPriceFilterList(){
		if(this.mPriceFilterList == null){
			this.mPriceFilterList = new SmartList<PriceFilter>();
			this.mPriceFilterList.setListInternalName (PRICE_FILTER_LIST );
			//有名字，便于做权限控制
		}
		
		return this.mPriceFilterList;	
	}
	public  void setPriceFilterList(SmartList<PriceFilter> priceFilterList){
		for( PriceFilter priceFilter:priceFilterList){
			priceFilter.setProfile(this);
		}

		this.mPriceFilterList = priceFilterList;
		this.mPriceFilterList.setListInternalName (PRICE_FILTER_LIST );
		
	}
	
	public  void addPriceFilter(PriceFilter priceFilter){
		priceFilter.setProfile(this);
		getPriceFilterList().add(priceFilter);
	}
	public  void addPriceFilterList(SmartList<PriceFilter> priceFilterList){
		for( PriceFilter priceFilter:priceFilterList){
			priceFilter.setProfile(this);
		}
		getPriceFilterList().addAll(priceFilterList);
	}
	
	public  PriceFilter removePriceFilter(PriceFilter priceFilterIndex){
		
		int index = getPriceFilterList().indexOf(priceFilterIndex);
        if(index < 0){
        	String message = "PriceFilter("+priceFilterIndex.getId()+") with version='"+priceFilterIndex.getVersion()+"' NOT found!";
            throw new IllegalStateException(message);
        }
        PriceFilter priceFilter = getPriceFilterList().get(index);        
        // priceFilter.clearProfile(); //disconnect with Profile
        priceFilter.clearFromAll(); //disconnect with Profile
		
		boolean result = getPriceFilterList().planToRemove(priceFilter);
        if(!result){
        	String message = "PriceFilter("+priceFilterIndex.getId()+") with version='"+priceFilterIndex.getVersion()+"' NOT found!";
            throw new IllegalStateException(message);
        }
        return priceFilter;
        
	
	}
	//断舍离
	public  void breakWithPriceFilter(PriceFilter priceFilter){
		
		if(priceFilter == null){
			return;
		}
		priceFilter.setProfile(null);
		//getPriceFilterList().remove();
	
	}
	
	public  boolean hasPriceFilter(PriceFilter priceFilter){
	
		return getPriceFilterList().contains(priceFilter);
  
	}
	
	public void copyPriceFilterFrom(PriceFilter priceFilter) {

		PriceFilter priceFilterInList = findThePriceFilter(priceFilter);
		PriceFilter newPriceFilter = new PriceFilter();
		priceFilterInList.copyTo(newPriceFilter);
		newPriceFilter.setVersion(0);//will trigger copy
		getPriceFilterList().add(newPriceFilter);
		addItemToFlexiableObject(COPIED_CHILD, newPriceFilter);
	}
	
	public  PriceFilter findThePriceFilter(PriceFilter priceFilter){
		
		int index =  getPriceFilterList().indexOf(priceFilter);
		//The input parameter must have the same id and version number.
		if(index < 0){
 			String message = "PriceFilter("+priceFilter.getId()+") with version='"+priceFilter.getVersion()+"' NOT found!";
			throw new IllegalStateException(message);
		}
		
		return  getPriceFilterList().get(index);
		//Performance issue when using LinkedList, but it is almost an ArrayList for sure!
	}
	
	public  void cleanUpPriceFilterList(){
		getPriceFilterList().clear();
	}
	
	
	


	public  SmartList<CategoryFilter> getCategoryFilterList(){
		if(this.mCategoryFilterList == null){
			this.mCategoryFilterList = new SmartList<CategoryFilter>();
			this.mCategoryFilterList.setListInternalName (CATEGORY_FILTER_LIST );
			//有名字，便于做权限控制
		}
		
		return this.mCategoryFilterList;	
	}
	public  void setCategoryFilterList(SmartList<CategoryFilter> categoryFilterList){
		for( CategoryFilter categoryFilter:categoryFilterList){
			categoryFilter.setProfile(this);
		}

		this.mCategoryFilterList = categoryFilterList;
		this.mCategoryFilterList.setListInternalName (CATEGORY_FILTER_LIST );
		
	}
	
	public  void addCategoryFilter(CategoryFilter categoryFilter){
		categoryFilter.setProfile(this);
		getCategoryFilterList().add(categoryFilter);
	}
	public  void addCategoryFilterList(SmartList<CategoryFilter> categoryFilterList){
		for( CategoryFilter categoryFilter:categoryFilterList){
			categoryFilter.setProfile(this);
		}
		getCategoryFilterList().addAll(categoryFilterList);
	}
	
	public  CategoryFilter removeCategoryFilter(CategoryFilter categoryFilterIndex){
		
		int index = getCategoryFilterList().indexOf(categoryFilterIndex);
        if(index < 0){
        	String message = "CategoryFilter("+categoryFilterIndex.getId()+") with version='"+categoryFilterIndex.getVersion()+"' NOT found!";
            throw new IllegalStateException(message);
        }
        CategoryFilter categoryFilter = getCategoryFilterList().get(index);        
        // categoryFilter.clearProfile(); //disconnect with Profile
        categoryFilter.clearFromAll(); //disconnect with Profile
		
		boolean result = getCategoryFilterList().planToRemove(categoryFilter);
        if(!result){
        	String message = "CategoryFilter("+categoryFilterIndex.getId()+") with version='"+categoryFilterIndex.getVersion()+"' NOT found!";
            throw new IllegalStateException(message);
        }
        return categoryFilter;
        
	
	}
	//断舍离
	public  void breakWithCategoryFilter(CategoryFilter categoryFilter){
		
		if(categoryFilter == null){
			return;
		}
		categoryFilter.setProfile(null);
		//getCategoryFilterList().remove();
	
	}
	
	public  boolean hasCategoryFilter(CategoryFilter categoryFilter){
	
		return getCategoryFilterList().contains(categoryFilter);
  
	}
	
	public void copyCategoryFilterFrom(CategoryFilter categoryFilter) {

		CategoryFilter categoryFilterInList = findTheCategoryFilter(categoryFilter);
		CategoryFilter newCategoryFilter = new CategoryFilter();
		categoryFilterInList.copyTo(newCategoryFilter);
		newCategoryFilter.setVersion(0);//will trigger copy
		getCategoryFilterList().add(newCategoryFilter);
		addItemToFlexiableObject(COPIED_CHILD, newCategoryFilter);
	}
	
	public  CategoryFilter findTheCategoryFilter(CategoryFilter categoryFilter){
		
		int index =  getCategoryFilterList().indexOf(categoryFilter);
		//The input parameter must have the same id and version number.
		if(index < 0){
 			String message = "CategoryFilter("+categoryFilter.getId()+") with version='"+categoryFilter.getVersion()+"' NOT found!";
			throw new IllegalStateException(message);
		}
		
		return  getCategoryFilterList().get(index);
		//Performance issue when using LinkedList, but it is almost an ArrayList for sure!
	}
	
	public  void cleanUpCategoryFilterList(){
		getCategoryFilterList().clear();
	}
	
	
	


	public  SmartList<NewProduct> getNewProductList(){
		if(this.mNewProductList == null){
			this.mNewProductList = new SmartList<NewProduct>();
			this.mNewProductList.setListInternalName (NEW_PRODUCT_LIST );
			//有名字，便于做权限控制
		}
		
		return this.mNewProductList;	
	}
	public  void setNewProductList(SmartList<NewProduct> newProductList){
		for( NewProduct newProduct:newProductList){
			newProduct.setProfile(this);
		}

		this.mNewProductList = newProductList;
		this.mNewProductList.setListInternalName (NEW_PRODUCT_LIST );
		
	}
	
	public  void addNewProduct(NewProduct newProduct){
		newProduct.setProfile(this);
		getNewProductList().add(newProduct);
	}
	public  void addNewProductList(SmartList<NewProduct> newProductList){
		for( NewProduct newProduct:newProductList){
			newProduct.setProfile(this);
		}
		getNewProductList().addAll(newProductList);
	}
	
	public  NewProduct removeNewProduct(NewProduct newProductIndex){
		
		int index = getNewProductList().indexOf(newProductIndex);
        if(index < 0){
        	String message = "NewProduct("+newProductIndex.getId()+") with version='"+newProductIndex.getVersion()+"' NOT found!";
            throw new IllegalStateException(message);
        }
        NewProduct newProduct = getNewProductList().get(index);        
        // newProduct.clearProfile(); //disconnect with Profile
        newProduct.clearFromAll(); //disconnect with Profile
		
		boolean result = getNewProductList().planToRemove(newProduct);
        if(!result){
        	String message = "NewProduct("+newProductIndex.getId()+") with version='"+newProductIndex.getVersion()+"' NOT found!";
            throw new IllegalStateException(message);
        }
        return newProduct;
        
	
	}
	//断舍离
	public  void breakWithNewProduct(NewProduct newProduct){
		
		if(newProduct == null){
			return;
		}
		newProduct.setProfile(null);
		//getNewProductList().remove();
	
	}
	
	public  boolean hasNewProduct(NewProduct newProduct){
	
		return getNewProductList().contains(newProduct);
  
	}
	
	public void copyNewProductFrom(NewProduct newProduct) {

		NewProduct newProductInList = findTheNewProduct(newProduct);
		NewProduct newNewProduct = new NewProduct();
		newProductInList.copyTo(newNewProduct);
		newNewProduct.setVersion(0);//will trigger copy
		getNewProductList().add(newNewProduct);
		addItemToFlexiableObject(COPIED_CHILD, newNewProduct);
	}
	
	public  NewProduct findTheNewProduct(NewProduct newProduct){
		
		int index =  getNewProductList().indexOf(newProduct);
		//The input parameter must have the same id and version number.
		if(index < 0){
 			String message = "NewProduct("+newProduct.getId()+") with version='"+newProduct.getVersion()+"' NOT found!";
			throw new IllegalStateException(message);
		}
		
		return  getNewProductList().get(index);
		//Performance issue when using LinkedList, but it is almost an ArrayList for sure!
	}
	
	public  void cleanUpNewProductList(){
		getNewProductList().clear();
	}
	
	
	


	public  SmartList<EditorPickProduct> getEditorPickProductList(){
		if(this.mEditorPickProductList == null){
			this.mEditorPickProductList = new SmartList<EditorPickProduct>();
			this.mEditorPickProductList.setListInternalName (EDITOR_PICK_PRODUCT_LIST );
			//有名字，便于做权限控制
		}
		
		return this.mEditorPickProductList;	
	}
	public  void setEditorPickProductList(SmartList<EditorPickProduct> editorPickProductList){
		for( EditorPickProduct editorPickProduct:editorPickProductList){
			editorPickProduct.setProfile(this);
		}

		this.mEditorPickProductList = editorPickProductList;
		this.mEditorPickProductList.setListInternalName (EDITOR_PICK_PRODUCT_LIST );
		
	}
	
	public  void addEditorPickProduct(EditorPickProduct editorPickProduct){
		editorPickProduct.setProfile(this);
		getEditorPickProductList().add(editorPickProduct);
	}
	public  void addEditorPickProductList(SmartList<EditorPickProduct> editorPickProductList){
		for( EditorPickProduct editorPickProduct:editorPickProductList){
			editorPickProduct.setProfile(this);
		}
		getEditorPickProductList().addAll(editorPickProductList);
	}
	
	public  EditorPickProduct removeEditorPickProduct(EditorPickProduct editorPickProductIndex){
		
		int index = getEditorPickProductList().indexOf(editorPickProductIndex);
        if(index < 0){
        	String message = "EditorPickProduct("+editorPickProductIndex.getId()+") with version='"+editorPickProductIndex.getVersion()+"' NOT found!";
            throw new IllegalStateException(message);
        }
        EditorPickProduct editorPickProduct = getEditorPickProductList().get(index);        
        // editorPickProduct.clearProfile(); //disconnect with Profile
        editorPickProduct.clearFromAll(); //disconnect with Profile
		
		boolean result = getEditorPickProductList().planToRemove(editorPickProduct);
        if(!result){
        	String message = "EditorPickProduct("+editorPickProductIndex.getId()+") with version='"+editorPickProductIndex.getVersion()+"' NOT found!";
            throw new IllegalStateException(message);
        }
        return editorPickProduct;
        
	
	}
	//断舍离
	public  void breakWithEditorPickProduct(EditorPickProduct editorPickProduct){
		
		if(editorPickProduct == null){
			return;
		}
		editorPickProduct.setProfile(null);
		//getEditorPickProductList().remove();
	
	}
	
	public  boolean hasEditorPickProduct(EditorPickProduct editorPickProduct){
	
		return getEditorPickProductList().contains(editorPickProduct);
  
	}
	
	public void copyEditorPickProductFrom(EditorPickProduct editorPickProduct) {

		EditorPickProduct editorPickProductInList = findTheEditorPickProduct(editorPickProduct);
		EditorPickProduct newEditorPickProduct = new EditorPickProduct();
		editorPickProductInList.copyTo(newEditorPickProduct);
		newEditorPickProduct.setVersion(0);//will trigger copy
		getEditorPickProductList().add(newEditorPickProduct);
		addItemToFlexiableObject(COPIED_CHILD, newEditorPickProduct);
	}
	
	public  EditorPickProduct findTheEditorPickProduct(EditorPickProduct editorPickProduct){
		
		int index =  getEditorPickProductList().indexOf(editorPickProduct);
		//The input parameter must have the same id and version number.
		if(index < 0){
 			String message = "EditorPickProduct("+editorPickProduct.getId()+") with version='"+editorPickProduct.getVersion()+"' NOT found!";
			throw new IllegalStateException(message);
		}
		
		return  getEditorPickProductList().get(index);
		//Performance issue when using LinkedList, but it is almost an ArrayList for sure!
	}
	
	public  void cleanUpEditorPickProductList(){
		getEditorPickProductList().clear();
	}
	
	
	


	public  SmartList<TopRatedProduct> getTopRatedProductList(){
		if(this.mTopRatedProductList == null){
			this.mTopRatedProductList = new SmartList<TopRatedProduct>();
			this.mTopRatedProductList.setListInternalName (TOP_RATED_PRODUCT_LIST );
			//有名字，便于做权限控制
		}
		
		return this.mTopRatedProductList;	
	}
	public  void setTopRatedProductList(SmartList<TopRatedProduct> topRatedProductList){
		for( TopRatedProduct topRatedProduct:topRatedProductList){
			topRatedProduct.setProfile(this);
		}

		this.mTopRatedProductList = topRatedProductList;
		this.mTopRatedProductList.setListInternalName (TOP_RATED_PRODUCT_LIST );
		
	}
	
	public  void addTopRatedProduct(TopRatedProduct topRatedProduct){
		topRatedProduct.setProfile(this);
		getTopRatedProductList().add(topRatedProduct);
	}
	public  void addTopRatedProductList(SmartList<TopRatedProduct> topRatedProductList){
		for( TopRatedProduct topRatedProduct:topRatedProductList){
			topRatedProduct.setProfile(this);
		}
		getTopRatedProductList().addAll(topRatedProductList);
	}
	
	public  TopRatedProduct removeTopRatedProduct(TopRatedProduct topRatedProductIndex){
		
		int index = getTopRatedProductList().indexOf(topRatedProductIndex);
        if(index < 0){
        	String message = "TopRatedProduct("+topRatedProductIndex.getId()+") with version='"+topRatedProductIndex.getVersion()+"' NOT found!";
            throw new IllegalStateException(message);
        }
        TopRatedProduct topRatedProduct = getTopRatedProductList().get(index);        
        // topRatedProduct.clearProfile(); //disconnect with Profile
        topRatedProduct.clearFromAll(); //disconnect with Profile
		
		boolean result = getTopRatedProductList().planToRemove(topRatedProduct);
        if(!result){
        	String message = "TopRatedProduct("+topRatedProductIndex.getId()+") with version='"+topRatedProductIndex.getVersion()+"' NOT found!";
            throw new IllegalStateException(message);
        }
        return topRatedProduct;
        
	
	}
	//断舍离
	public  void breakWithTopRatedProduct(TopRatedProduct topRatedProduct){
		
		if(topRatedProduct == null){
			return;
		}
		topRatedProduct.setProfile(null);
		//getTopRatedProductList().remove();
	
	}
	
	public  boolean hasTopRatedProduct(TopRatedProduct topRatedProduct){
	
		return getTopRatedProductList().contains(topRatedProduct);
  
	}
	
	public void copyTopRatedProductFrom(TopRatedProduct topRatedProduct) {

		TopRatedProduct topRatedProductInList = findTheTopRatedProduct(topRatedProduct);
		TopRatedProduct newTopRatedProduct = new TopRatedProduct();
		topRatedProductInList.copyTo(newTopRatedProduct);
		newTopRatedProduct.setVersion(0);//will trigger copy
		getTopRatedProductList().add(newTopRatedProduct);
		addItemToFlexiableObject(COPIED_CHILD, newTopRatedProduct);
	}
	
	public  TopRatedProduct findTheTopRatedProduct(TopRatedProduct topRatedProduct){
		
		int index =  getTopRatedProductList().indexOf(topRatedProduct);
		//The input parameter must have the same id and version number.
		if(index < 0){
 			String message = "TopRatedProduct("+topRatedProduct.getId()+") with version='"+topRatedProduct.getVersion()+"' NOT found!";
			throw new IllegalStateException(message);
		}
		
		return  getTopRatedProductList().get(index);
		//Performance issue when using LinkedList, but it is almost an ArrayList for sure!
	}
	
	public  void cleanUpTopRatedProductList(){
		getTopRatedProductList().clear();
	}
	
	
	


	public  SmartList<RecommandProduct> getRecommandProductList(){
		if(this.mRecommandProductList == null){
			this.mRecommandProductList = new SmartList<RecommandProduct>();
			this.mRecommandProductList.setListInternalName (RECOMMAND_PRODUCT_LIST );
			//有名字，便于做权限控制
		}
		
		return this.mRecommandProductList;	
	}
	public  void setRecommandProductList(SmartList<RecommandProduct> recommandProductList){
		for( RecommandProduct recommandProduct:recommandProductList){
			recommandProduct.setProfile(this);
		}

		this.mRecommandProductList = recommandProductList;
		this.mRecommandProductList.setListInternalName (RECOMMAND_PRODUCT_LIST );
		
	}
	
	public  void addRecommandProduct(RecommandProduct recommandProduct){
		recommandProduct.setProfile(this);
		getRecommandProductList().add(recommandProduct);
	}
	public  void addRecommandProductList(SmartList<RecommandProduct> recommandProductList){
		for( RecommandProduct recommandProduct:recommandProductList){
			recommandProduct.setProfile(this);
		}
		getRecommandProductList().addAll(recommandProductList);
	}
	
	public  RecommandProduct removeRecommandProduct(RecommandProduct recommandProductIndex){
		
		int index = getRecommandProductList().indexOf(recommandProductIndex);
        if(index < 0){
        	String message = "RecommandProduct("+recommandProductIndex.getId()+") with version='"+recommandProductIndex.getVersion()+"' NOT found!";
            throw new IllegalStateException(message);
        }
        RecommandProduct recommandProduct = getRecommandProductList().get(index);        
        // recommandProduct.clearProfile(); //disconnect with Profile
        recommandProduct.clearFromAll(); //disconnect with Profile
		
		boolean result = getRecommandProductList().planToRemove(recommandProduct);
        if(!result){
        	String message = "RecommandProduct("+recommandProductIndex.getId()+") with version='"+recommandProductIndex.getVersion()+"' NOT found!";
            throw new IllegalStateException(message);
        }
        return recommandProduct;
        
	
	}
	//断舍离
	public  void breakWithRecommandProduct(RecommandProduct recommandProduct){
		
		if(recommandProduct == null){
			return;
		}
		recommandProduct.setProfile(null);
		//getRecommandProductList().remove();
	
	}
	
	public  boolean hasRecommandProduct(RecommandProduct recommandProduct){
	
		return getRecommandProductList().contains(recommandProduct);
  
	}
	
	public void copyRecommandProductFrom(RecommandProduct recommandProduct) {

		RecommandProduct recommandProductInList = findTheRecommandProduct(recommandProduct);
		RecommandProduct newRecommandProduct = new RecommandProduct();
		recommandProductInList.copyTo(newRecommandProduct);
		newRecommandProduct.setVersion(0);//will trigger copy
		getRecommandProductList().add(newRecommandProduct);
		addItemToFlexiableObject(COPIED_CHILD, newRecommandProduct);
	}
	
	public  RecommandProduct findTheRecommandProduct(RecommandProduct recommandProduct){
		
		int index =  getRecommandProductList().indexOf(recommandProduct);
		//The input parameter must have the same id and version number.
		if(index < 0){
 			String message = "RecommandProduct("+recommandProduct.getId()+") with version='"+recommandProduct.getVersion()+"' NOT found!";
			throw new IllegalStateException(message);
		}
		
		return  getRecommandProductList().get(index);
		//Performance issue when using LinkedList, but it is almost an ArrayList for sure!
	}
	
	public  void cleanUpRecommandProductList(){
		getRecommandProductList().clear();
	}
	
	
	


	public void collectRefercences(BaseEntity owner, List<BaseEntity> entityList, String internalType){

		addToEntityList(this, entityList, getPlatform(), internalType);

		
	}
	
	public List<BaseEntity>  collectRefercencesFromLists(String internalType){
		
		List<BaseEntity> entityList = new ArrayList<BaseEntity>();
		collectFromList(this, entityList, getBrandFilterList(), internalType);
		collectFromList(this, entityList, getPriceFilterList(), internalType);
		collectFromList(this, entityList, getCategoryFilterList(), internalType);
		collectFromList(this, entityList, getNewProductList(), internalType);
		collectFromList(this, entityList, getEditorPickProductList(), internalType);
		collectFromList(this, entityList, getTopRatedProductList(), internalType);
		collectFromList(this, entityList, getRecommandProductList(), internalType);

		return entityList;
	}
	
	public  List<SmartList<?>> getAllRelatedLists() {
		List<SmartList<?>> listOfList = new ArrayList<SmartList<?>>();
		
		listOfList.add( getBrandFilterList());
		listOfList.add( getPriceFilterList());
		listOfList.add( getCategoryFilterList());
		listOfList.add( getNewProductList());
		listOfList.add( getEditorPickProductList());
		listOfList.add( getTopRatedProductList());
		listOfList.add( getRecommandProductList());
			

		return listOfList;
	}

	
	public List<KeyValuePair> keyValuePairOf(){
		List<KeyValuePair> result =  super.keyValuePairOf();

		appendKeyValuePair(result, ID_PROPERTY, getId());
		appendKeyValuePair(result, NAME_PROPERTY, getName());
		appendKeyValuePair(result, PLATFORM_PROPERTY, getPlatform());
		appendKeyValuePair(result, VERSION_PROPERTY, getVersion());
		appendKeyValuePair(result, BRAND_FILTER_LIST, getBrandFilterList());
		if(!getBrandFilterList().isEmpty()){
			appendKeyValuePair(result, "brandFilterCount", getBrandFilterList().getTotalCount());
			appendKeyValuePair(result, "brandFilterCurrentPageNumber", getBrandFilterList().getCurrentPageNumber());
		}
		appendKeyValuePair(result, PRICE_FILTER_LIST, getPriceFilterList());
		if(!getPriceFilterList().isEmpty()){
			appendKeyValuePair(result, "priceFilterCount", getPriceFilterList().getTotalCount());
			appendKeyValuePair(result, "priceFilterCurrentPageNumber", getPriceFilterList().getCurrentPageNumber());
		}
		appendKeyValuePair(result, CATEGORY_FILTER_LIST, getCategoryFilterList());
		if(!getCategoryFilterList().isEmpty()){
			appendKeyValuePair(result, "categoryFilterCount", getCategoryFilterList().getTotalCount());
			appendKeyValuePair(result, "categoryFilterCurrentPageNumber", getCategoryFilterList().getCurrentPageNumber());
		}
		appendKeyValuePair(result, NEW_PRODUCT_LIST, getNewProductList());
		if(!getNewProductList().isEmpty()){
			appendKeyValuePair(result, "newProductCount", getNewProductList().getTotalCount());
			appendKeyValuePair(result, "newProductCurrentPageNumber", getNewProductList().getCurrentPageNumber());
		}
		appendKeyValuePair(result, EDITOR_PICK_PRODUCT_LIST, getEditorPickProductList());
		if(!getEditorPickProductList().isEmpty()){
			appendKeyValuePair(result, "editorPickProductCount", getEditorPickProductList().getTotalCount());
			appendKeyValuePair(result, "editorPickProductCurrentPageNumber", getEditorPickProductList().getCurrentPageNumber());
		}
		appendKeyValuePair(result, TOP_RATED_PRODUCT_LIST, getTopRatedProductList());
		if(!getTopRatedProductList().isEmpty()){
			appendKeyValuePair(result, "topRatedProductCount", getTopRatedProductList().getTotalCount());
			appendKeyValuePair(result, "topRatedProductCurrentPageNumber", getTopRatedProductList().getCurrentPageNumber());
		}
		appendKeyValuePair(result, RECOMMAND_PRODUCT_LIST, getRecommandProductList());
		if(!getRecommandProductList().isEmpty()){
			appendKeyValuePair(result, "recommandProductCount", getRecommandProductList().getTotalCount());
			appendKeyValuePair(result, "recommandProductCurrentPageNumber", getRecommandProductList().getCurrentPageNumber());
		}

		
		return result;
	}
	
	
	public BaseEntity copyTo(BaseEntity baseDest){
		
		
		if(baseDest instanceof Profile){
		
		
			Profile dest =(Profile)baseDest;
		
			dest.setId(getId());
			dest.setName(getName());
			dest.setPlatform(getPlatform());
			dest.setVersion(getVersion());
			dest.setBrandFilterList(getBrandFilterList());
			dest.setPriceFilterList(getPriceFilterList());
			dest.setCategoryFilterList(getCategoryFilterList());
			dest.setNewProductList(getNewProductList());
			dest.setEditorPickProductList(getEditorPickProductList());
			dest.setTopRatedProductList(getTopRatedProductList());
			dest.setRecommandProductList(getRecommandProductList());

		}
		super.copyTo(baseDest);
		return baseDest;
	}
	
	public String toString(){
		StringBuilder stringBuilder=new StringBuilder(128);

		stringBuilder.append("Profile{");
		stringBuilder.append("\tid='"+getId()+"';");
		stringBuilder.append("\tname='"+getName()+"';");
		if(getPlatform() != null ){
 			stringBuilder.append("\tplatform='Platform("+getPlatform().getId()+")';");
 		}
		stringBuilder.append("\tversion='"+getVersion()+"';");
		stringBuilder.append("}");

		return stringBuilder.toString();
	}
	
	//provide number calculation function
	

}

