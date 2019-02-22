package com.terapico.pim;
import java.text.MessageFormat;
import java.util.Date;
import com.terapico.uccaf.BaseUserContext;
import java.util.List;
import java.math.BigDecimal;
import com.terapico.caf.DateTime;
public class PimCheckerManager extends BaseManagerImpl {
	/*
	
	
	public static final String  ID_OF_PLATFORM ="platform.id";
	protected void checkIdOfPlatform(PimUserContext userContext, String id, List<Message> messageList)
	{
		
	 	checkStringLengthRange(id,5, 64,ID_OF_PLATFORM, messageList); 		
		
	}	 			
	
	public static final String  NAME_OF_PLATFORM ="platform.name";
	protected void checkNameOfPlatform(PimUserContext userContext, String name, List<Message> messageList)
	{
		
	 	checkStringLengthRange(name,6, 92,NAME_OF_PLATFORM, messageList); 		
		
	}	 			
	
	public static final String  INTRODUCTION_OF_PLATFORM ="platform.introduction";
	protected void checkIntroductionOfPlatform(PimUserContext userContext, String introduction, List<Message> messageList)
	{
		
	 	checkStringLengthRange(introduction,19, 288,INTRODUCTION_OF_PLATFORM, messageList); 		
		
	}	 			
	
	public static final String  CURRENT_VERSION_OF_PLATFORM ="platform.current_version";
	protected void checkCurrentVersionOfPlatform(PimUserContext userContext, String currentVersion, List<Message> messageList)
	{
		
	 	checkStringLengthRange(currentVersion,2, 16,CURRENT_VERSION_OF_PLATFORM, messageList); 		
		
	}	 			
	
	public static final String  VERSION_OF_PLATFORM ="platform.version";
	protected void checkVersionOfPlatform(PimUserContext userContext, int version, List<Message> messageList)
	{
		
	 	checkIntegerRange(version,0, Integer.MAX_VALUE,VERSION_OF_PLATFORM, messageList); 		
		
	}	 			
	
	public static final String  ID_OF_SITE ="site.id";
	protected void checkIdOfSite(PimUserContext userContext, String id, List<Message> messageList)
	{
		
	 	checkStringLengthRange(id,5, 64,ID_OF_SITE, messageList); 		
		
	}	 			
	
	public static final String  NAME_OF_SITE ="site.name";
	protected void checkNameOfSite(PimUserContext userContext, String name, List<Message> messageList)
	{
		
	 	checkStringLengthRange(name,6, 92,NAME_OF_SITE, messageList); 		
		
	}	 			
	
	public static final String  INTRODUCTION_OF_SITE ="site.introduction";
	protected void checkIntroductionOfSite(PimUserContext userContext, String introduction, List<Message> messageList)
	{
		
	 	checkStringLengthRange(introduction,10, 148,INTRODUCTION_OF_SITE, messageList); 		
		
	}	 			
	
	public static final String  PLATFORM_OF_SITE ="site.platform";
	protected void checkPlatformIdOfSite(PimUserContext userContext, String platformId, List<Message> messageList)
	{
		
	 	checkIdOfSite(userContext,platformId, messageList); 		
		
	}	 			
	
	public static final String  VERSION_OF_SITE ="site.version";
	protected void checkVersionOfSite(PimUserContext userContext, int version, List<Message> messageList)
	{
		
	 	checkIntegerRange(version,0, Integer.MAX_VALUE,VERSION_OF_SITE, messageList); 		
		
	}	 			
	
	public static final String  ID_OF_CATALOG ="catalog.id";
	protected void checkIdOfCatalog(PimUserContext userContext, String id, List<Message> messageList)
	{
		
	 	checkStringLengthRange(id,5, 64,ID_OF_CATALOG, messageList); 		
		
	}	 			
	
	public static final String  NAME_OF_CATALOG ="catalog.name";
	protected void checkNameOfCatalog(PimUserContext userContext, String name, List<Message> messageList)
	{
		
	 	checkStringLengthRange(name,2, 20,NAME_OF_CATALOG, messageList); 		
		
	}	 			
	
	public static final String  SELLER_ID_OF_CATALOG ="catalog.seller_id";
	protected void checkSellerIdOfCatalog(PimUserContext userContext, String sellerId, List<Message> messageList)
	{
		
	 	checkStringLengthRange(sellerId,3, 32,SELLER_ID_OF_CATALOG, messageList); 		
		
	}	 			
	
	public static final String  SITE_OF_CATALOG ="catalog.site";
	protected void checkSiteIdOfCatalog(PimUserContext userContext, String siteId, List<Message> messageList)
	{
		
	 	checkIdOfCatalog(userContext,siteId, messageList); 		
		
	}	 			
	
	public static final String  PLATFORM_OF_CATALOG ="catalog.platform";
	protected void checkPlatformIdOfCatalog(PimUserContext userContext, String platformId, List<Message> messageList)
	{
		
	 	checkIdOfCatalog(userContext,platformId, messageList); 		
		
	}	 			
	
	public static final String  VERSION_OF_CATALOG ="catalog.version";
	protected void checkVersionOfCatalog(PimUserContext userContext, int version, List<Message> messageList)
	{
		
	 	checkIntegerRange(version,0, Integer.MAX_VALUE,VERSION_OF_CATALOG, messageList); 		
		
	}	 			
	
	public static final String  ID_OF_LEVEL_ONE_CATEGORY ="level_one_category.id";
	protected void checkIdOfLevelOneCategory(PimUserContext userContext, String id, List<Message> messageList)
	{
		
	 	checkStringLengthRange(id,5, 64,ID_OF_LEVEL_ONE_CATEGORY, messageList); 		
		
	}	 			
	
	public static final String  CATALOG_OF_LEVEL_ONE_CATEGORY ="level_one_category.catalog";
	protected void checkCatalogIdOfLevelOneCategory(PimUserContext userContext, String catalogId, List<Message> messageList)
	{
		
	 	checkIdOfLevelOneCategory(userContext,catalogId, messageList); 		
		
	}	 			
	
	public static final String  NAME_OF_LEVEL_ONE_CATEGORY ="level_one_category.name";
	protected void checkNameOfLevelOneCategory(PimUserContext userContext, String name, List<Message> messageList)
	{
		
	 	checkStringLengthRange(name,4, 52,NAME_OF_LEVEL_ONE_CATEGORY, messageList); 		
		
	}	 			
	
	public static final String  VERSION_OF_LEVEL_ONE_CATEGORY ="level_one_category.version";
	protected void checkVersionOfLevelOneCategory(PimUserContext userContext, int version, List<Message> messageList)
	{
		
	 	checkIntegerRange(version,0, Integer.MAX_VALUE,VERSION_OF_LEVEL_ONE_CATEGORY, messageList); 		
		
	}	 			
	
	public static final String  ID_OF_LEVEL_TWO_CATEGORY ="level_two_category.id";
	protected void checkIdOfLevelTwoCategory(PimUserContext userContext, String id, List<Message> messageList)
	{
		
	 	checkStringLengthRange(id,5, 64,ID_OF_LEVEL_TWO_CATEGORY, messageList); 		
		
	}	 			
	
	public static final String  PARENT_CATEGORY_OF_LEVEL_TWO_CATEGORY ="level_two_category.parent_category";
	protected void checkParentCategoryIdOfLevelTwoCategory(PimUserContext userContext, String parentCategoryId, List<Message> messageList)
	{
		
	 	checkIdOfLevelTwoCategory(userContext,parentCategoryId, messageList); 		
		
	}	 			
	
	public static final String  NAME_OF_LEVEL_TWO_CATEGORY ="level_two_category.name";
	protected void checkNameOfLevelTwoCategory(PimUserContext userContext, String name, List<Message> messageList)
	{
		
	 	checkStringLengthRange(name,4, 52,NAME_OF_LEVEL_TWO_CATEGORY, messageList); 		
		
	}	 			
	
	public static final String  VERSION_OF_LEVEL_TWO_CATEGORY ="level_two_category.version";
	protected void checkVersionOfLevelTwoCategory(PimUserContext userContext, int version, List<Message> messageList)
	{
		
	 	checkIntegerRange(version,0, Integer.MAX_VALUE,VERSION_OF_LEVEL_TWO_CATEGORY, messageList); 		
		
	}	 			
	
	public static final String  ID_OF_LEVEL_N_CATEGORY ="level_n_category.id";
	protected void checkIdOfLevelNCategory(PimUserContext userContext, String id, List<Message> messageList)
	{
		
	 	checkStringLengthRange(id,5, 64,ID_OF_LEVEL_N_CATEGORY, messageList); 		
		
	}	 			
	
	public static final String  PARENT_CATEGORY_OF_LEVEL_N_CATEGORY ="level_n_category.parent_category";
	protected void checkParentCategoryIdOfLevelNCategory(PimUserContext userContext, String parentCategoryId, List<Message> messageList)
	{
		
	 	checkIdOfLevelNCategory(userContext,parentCategoryId, messageList); 		
		
	}	 			
	
	public static final String  NAME_OF_LEVEL_N_CATEGORY ="level_n_category.name";
	protected void checkNameOfLevelNCategory(PimUserContext userContext, String name, List<Message> messageList)
	{
		
	 	checkStringLengthRange(name,3, 44,NAME_OF_LEVEL_N_CATEGORY, messageList); 		
		
	}	 			
	
	public static final String  VERSION_OF_LEVEL_N_CATEGORY ="level_n_category.version";
	protected void checkVersionOfLevelNCategory(PimUserContext userContext, int version, List<Message> messageList)
	{
		
	 	checkIntegerRange(version,0, Integer.MAX_VALUE,VERSION_OF_LEVEL_N_CATEGORY, messageList); 		
		
	}	 			
	
	public static final String  ID_OF_BRAND ="brand.id";
	protected void checkIdOfBrand(PimUserContext userContext, String id, List<Message> messageList)
	{
		
	 	checkStringLengthRange(id,5, 64,ID_OF_BRAND, messageList); 		
		
	}	 			
	
	public static final String  BRAND_NAME_OF_BRAND ="brand.brand_name";
	protected void checkBrandNameOfBrand(PimUserContext userContext, String brandName, List<Message> messageList)
	{
		
	 	checkStringLengthRange(brandName,3, 40,BRAND_NAME_OF_BRAND, messageList); 		
		
	}	 			
	
	public static final String  LOGO_OF_BRAND ="brand.logo";
	protected void checkLogoOfBrand(PimUserContext userContext, String logo, List<Message> messageList)
	{
		
	 	checkImage(logo,0, 512,LOGO_OF_BRAND, messageList); 		
		
	}	 			
	
	public static final String  REMARK_OF_BRAND ="brand.remark";
	protected void checkRemarkOfBrand(PimUserContext userContext, String remark, List<Message> messageList)
	{
		
	 	checkStringLengthRange(remark,22, 336,REMARK_OF_BRAND, messageList); 		
		
	}	 			
	
	public static final String  PLATFORM_OF_BRAND ="brand.platform";
	protected void checkPlatformIdOfBrand(PimUserContext userContext, String platformId, List<Message> messageList)
	{
		
	 	checkIdOfBrand(userContext,platformId, messageList); 		
		
	}	 			
	
	public static final String  VERSION_OF_BRAND ="brand.version";
	protected void checkVersionOfBrand(PimUserContext userContext, int version, List<Message> messageList)
	{
		
	 	checkIntegerRange(version,0, Integer.MAX_VALUE,VERSION_OF_BRAND, messageList); 		
		
	}	 			
	
	public static final String  ID_OF_PRODUCT ="product.id";
	protected void checkIdOfProduct(PimUserContext userContext, String id, List<Message> messageList)
	{
		
	 	checkStringLengthRange(id,5, 64,ID_OF_PRODUCT, messageList); 		
		
	}	 			
	
	public static final String  NAME_OF_PRODUCT ="product.name";
	protected void checkNameOfProduct(PimUserContext userContext, String name, List<Message> messageList)
	{
		
	 	checkStringLengthRange(name,2, 20,NAME_OF_PRODUCT, messageList); 		
		
	}	 			
	
	public static final String  PARENT_CATEGORY_OF_PRODUCT ="product.parent_category";
	protected void checkParentCategoryIdOfProduct(PimUserContext userContext, String parentCategoryId, List<Message> messageList)
	{
		
	 	checkIdOfProduct(userContext,parentCategoryId, messageList); 		
		
	}	 			
	
	public static final String  BRAND_OF_PRODUCT ="product.brand";
	protected void checkBrandIdOfProduct(PimUserContext userContext, String brandId, List<Message> messageList)
	{
		
	 	checkIdOfProduct(userContext,brandId, messageList); 		
		
	}	 			
	
	public static final String  PRODUCT_COVER_IMAGE_OF_PRODUCT ="product.product_cover_image";
	protected void checkProductCoverImageOfProduct(PimUserContext userContext, String productCoverImage, List<Message> messageList)
	{
		
	 	checkImage(productCoverImage,0, 512,PRODUCT_COVER_IMAGE_OF_PRODUCT, messageList); 		
		
	}	 			
	
	public static final String  ORIGIN_OF_PRODUCT ="product.origin";
	protected void checkOriginOfProduct(PimUserContext userContext, String origin, List<Message> messageList)
	{
		
	 	checkStringLengthRange(origin,1, 24,ORIGIN_OF_PRODUCT, messageList); 		
		
	}	 			
	
	public static final String  CATALOG_OF_PRODUCT ="product.catalog";
	protected void checkCatalogIdOfProduct(PimUserContext userContext, String catalogId, List<Message> messageList)
	{
		
	 	checkIdOfProduct(userContext,catalogId, messageList); 		
		
	}	 			
	
	public static final String  REMARK_OF_PRODUCT ="product.remark";
	protected void checkRemarkOfProduct(PimUserContext userContext, String remark, List<Message> messageList)
	{
		
	 	checkStringLengthRange(remark,22, 336,REMARK_OF_PRODUCT, messageList); 		
		
	}	 			
	
	public static final String  PLATFORM_OF_PRODUCT ="product.platform";
	protected void checkPlatformIdOfProduct(PimUserContext userContext, String platformId, List<Message> messageList)
	{
		
	 	checkIdOfProduct(userContext,platformId, messageList); 		
		
	}	 			
	
	public static final String  VERSION_OF_PRODUCT ="product.version";
	protected void checkVersionOfProduct(PimUserContext userContext, int version, List<Message> messageList)
	{
		
	 	checkIntegerRange(version,0, Integer.MAX_VALUE,VERSION_OF_PRODUCT, messageList); 		
		
	}	 			
	
	public static final String  ID_OF_SKU ="sku.id";
	protected void checkIdOfSku(PimUserContext userContext, String id, List<Message> messageList)
	{
		
	 	checkStringLengthRange(id,5, 64,ID_OF_SKU, messageList); 		
		
	}	 			
	
	public static final String  NAME_OF_SKU ="sku.name";
	protected void checkNameOfSku(PimUserContext userContext, String name, List<Message> messageList)
	{
		
	 	checkStringLengthRange(name,4, 52,NAME_OF_SKU, messageList); 		
		
	}	 			
	
	public static final String  SIZE_OF_SKU ="sku.size";
	protected void checkSizeOfSku(PimUserContext userContext, String size, List<Message> messageList)
	{
		
	 	checkStringLengthRange(size,2, 24,SIZE_OF_SKU, messageList); 		
		
	}	 			
	
	public static final String  PRODUCT_OF_SKU ="sku.product";
	protected void checkProductIdOfSku(PimUserContext userContext, String productId, List<Message> messageList)
	{
		
	 	checkIdOfSku(userContext,productId, messageList); 		
		
	}	 			
	
	public static final String  ACTIVE_OF_SKU ="sku.active";
	protected void checkActiveOfSku(PimUserContext userContext, boolean active, List<Message> messageList)
	{
		
	 	checkBooleanRange(active,0, true,ACTIVE_OF_SKU, messageList); 		
		
	}	 			
	
	public static final String  BASE_PRICE_OF_SKU ="sku.base_price";
	protected void checkBasePriceOfSku(PimUserContext userContext, BigDecimal basePrice, List<Message> messageList)
	{
		
	 	checkMoneyAmount(basePrice,0.00, 103.21,BASE_PRICE_OF_SKU, messageList); 		
		
	}	 			
	
	public static final String  VERSION_OF_SKU ="sku.version";
	protected void checkVersionOfSku(PimUserContext userContext, int version, List<Message> messageList)
	{
		
	 	checkIntegerRange(version,0, Integer.MAX_VALUE,VERSION_OF_SKU, messageList); 		
		
	}	 			
	
	public static final String  ID_OF_PROFILE ="profile.id";
	protected void checkIdOfProfile(PimUserContext userContext, String id, List<Message> messageList)
	{
		
	 	checkStringLengthRange(id,5, 64,ID_OF_PROFILE, messageList); 		
		
	}	 			
	
	public static final String  NAME_OF_PROFILE ="profile.name";
	protected void checkNameOfProfile(PimUserContext userContext, String name, List<Message> messageList)
	{
		
	 	checkStringLengthRange(name,6, 72,NAME_OF_PROFILE, messageList); 		
		
	}	 			
	
	public static final String  PLATFORM_OF_PROFILE ="profile.platform";
	protected void checkPlatformIdOfProfile(PimUserContext userContext, String platformId, List<Message> messageList)
	{
		
	 	checkIdOfProfile(userContext,platformId, messageList); 		
		
	}	 			
	
	public static final String  VERSION_OF_PROFILE ="profile.version";
	protected void checkVersionOfProfile(PimUserContext userContext, int version, List<Message> messageList)
	{
		
	 	checkIntegerRange(version,0, Integer.MAX_VALUE,VERSION_OF_PROFILE, messageList); 		
		
	}	 			
	
	public static final String  ID_OF_BRAND_FILTER ="brand_filter.id";
	protected void checkIdOfBrandFilter(PimUserContext userContext, String id, List<Message> messageList)
	{
		
	 	checkStringLengthRange(id,5, 64,ID_OF_BRAND_FILTER, messageList); 		
		
	}	 			
	
	public static final String  NAME_OF_BRAND_FILTER ="brand_filter.name";
	protected void checkNameOfBrandFilter(PimUserContext userContext, String name, List<Message> messageList)
	{
		
	 	checkStringLengthRange(name,6, 72,NAME_OF_BRAND_FILTER, messageList); 		
		
	}	 			
	
	public static final String  INTERNAL_ID_OF_BRAND_FILTER ="brand_filter.internal_id";
	protected void checkInternalIdOfBrandFilter(PimUserContext userContext, String internalId, List<Message> messageList)
	{
		
	 	checkStringLengthRange(internalId,2, 28,INTERNAL_ID_OF_BRAND_FILTER, messageList); 		
		
	}	 			
	
	public static final String  PROFILE_OF_BRAND_FILTER ="brand_filter.profile";
	protected void checkProfileIdOfBrandFilter(PimUserContext userContext, String profileId, List<Message> messageList)
	{
		
	 	checkIdOfBrandFilter(userContext,profileId, messageList); 		
		
	}	 			
	
	public static final String  VERSION_OF_BRAND_FILTER ="brand_filter.version";
	protected void checkVersionOfBrandFilter(PimUserContext userContext, int version, List<Message> messageList)
	{
		
	 	checkIntegerRange(version,0, Integer.MAX_VALUE,VERSION_OF_BRAND_FILTER, messageList); 		
		
	}	 			
	
	public static final String  ID_OF_PRICE_FILTER ="price_filter.id";
	protected void checkIdOfPriceFilter(PimUserContext userContext, String id, List<Message> messageList)
	{
		
	 	checkStringLengthRange(id,5, 64,ID_OF_PRICE_FILTER, messageList); 		
		
	}	 			
	
	public static final String  NAME_OF_PRICE_FILTER ="price_filter.name";
	protected void checkNameOfPriceFilter(PimUserContext userContext, String name, List<Message> messageList)
	{
		
	 	checkStringLengthRange(name,6, 72,NAME_OF_PRICE_FILTER, messageList); 		
		
	}	 			
	
	public static final String  PRICE_START_OF_PRICE_FILTER ="price_filter.price_start";
	protected void checkPriceStartOfPriceFilter(PimUserContext userContext, BigDecimal priceStart, List<Message> messageList)
	{
		
	 	checkBigDecimalRange(priceStart,0, 1.99,PRICE_START_OF_PRICE_FILTER, messageList); 		
		
	}	 			
	
	public static final String  PRICE_END_OF_PRICE_FILTER ="price_filter.price_end";
	protected void checkPriceEndOfPriceFilter(PimUserContext userContext, BigDecimal priceEnd, List<Message> messageList)
	{
		
	 	checkBigDecimalRange(priceEnd,0, 1000000.99,PRICE_END_OF_PRICE_FILTER, messageList); 		
		
	}	 			
	
	public static final String  PROFILE_OF_PRICE_FILTER ="price_filter.profile";
	protected void checkProfileIdOfPriceFilter(PimUserContext userContext, String profileId, List<Message> messageList)
	{
		
	 	checkIdOfPriceFilter(userContext,profileId, messageList); 		
		
	}	 			
	
	public static final String  VERSION_OF_PRICE_FILTER ="price_filter.version";
	protected void checkVersionOfPriceFilter(PimUserContext userContext, int version, List<Message> messageList)
	{
		
	 	checkIntegerRange(version,0, Integer.MAX_VALUE,VERSION_OF_PRICE_FILTER, messageList); 		
		
	}	 			
	
	public static final String  ID_OF_CATEGORY_FILTER ="category_filter.id";
	protected void checkIdOfCategoryFilter(PimUserContext userContext, String id, List<Message> messageList)
	{
		
	 	checkStringLengthRange(id,5, 64,ID_OF_CATEGORY_FILTER, messageList); 		
		
	}	 			
	
	public static final String  NAME_OF_CATEGORY_FILTER ="category_filter.name";
	protected void checkNameOfCategoryFilter(PimUserContext userContext, String name, List<Message> messageList)
	{
		
	 	checkStringLengthRange(name,6, 72,NAME_OF_CATEGORY_FILTER, messageList); 		
		
	}	 			
	
	public static final String  INTERNAL_ID_OF_CATEGORY_FILTER ="category_filter.internal_id";
	protected void checkInternalIdOfCategoryFilter(PimUserContext userContext, String internalId, List<Message> messageList)
	{
		
	 	checkStringLengthRange(internalId,3, 32,INTERNAL_ID_OF_CATEGORY_FILTER, messageList); 		
		
	}	 			
	
	public static final String  PROFILE_OF_CATEGORY_FILTER ="category_filter.profile";
	protected void checkProfileIdOfCategoryFilter(PimUserContext userContext, String profileId, List<Message> messageList)
	{
		
	 	checkIdOfCategoryFilter(userContext,profileId, messageList); 		
		
	}	 			
	
	public static final String  VERSION_OF_CATEGORY_FILTER ="category_filter.version";
	protected void checkVersionOfCategoryFilter(PimUserContext userContext, int version, List<Message> messageList)
	{
		
	 	checkIntegerRange(version,0, Integer.MAX_VALUE,VERSION_OF_CATEGORY_FILTER, messageList); 		
		
	}	 			
	
	public static final String  ID_OF_NEW_PRODUCT ="new_product.id";
	protected void checkIdOfNewProduct(PimUserContext userContext, String id, List<Message> messageList)
	{
		
	 	checkStringLengthRange(id,5, 64,ID_OF_NEW_PRODUCT, messageList); 		
		
	}	 			
	
	public static final String  NAME_OF_NEW_PRODUCT ="new_product.name";
	protected void checkNameOfNewProduct(PimUserContext userContext, String name, List<Message> messageList)
	{
		
	 	checkStringLengthRange(name,2, 20,NAME_OF_NEW_PRODUCT, messageList); 		
		
	}	 			
	
	public static final String  PARENT_CATEGORY_OF_NEW_PRODUCT ="new_product.parent_category";
	protected void checkParentCategoryIdOfNewProduct(PimUserContext userContext, String parentCategoryId, List<Message> messageList)
	{
		
	 	checkIdOfNewProduct(userContext,parentCategoryId, messageList); 		
		
	}	 			
	
	public static final String  BRAND_OF_NEW_PRODUCT ="new_product.brand";
	protected void checkBrandIdOfNewProduct(PimUserContext userContext, String brandId, List<Message> messageList)
	{
		
	 	checkIdOfNewProduct(userContext,brandId, messageList); 		
		
	}	 			
	
	public static final String  PRODUCT_COVER_IMAGE_OF_NEW_PRODUCT ="new_product.product_cover_image";
	protected void checkProductCoverImageOfNewProduct(PimUserContext userContext, String productCoverImage, List<Message> messageList)
	{
		
	 	checkImage(productCoverImage,0, 512,PRODUCT_COVER_IMAGE_OF_NEW_PRODUCT, messageList); 		
		
	}	 			
	
	public static final String  ORIGIN_OF_NEW_PRODUCT ="new_product.origin";
	protected void checkOriginOfNewProduct(PimUserContext userContext, String origin, List<Message> messageList)
	{
		
	 	checkStringLengthRange(origin,1, 24,ORIGIN_OF_NEW_PRODUCT, messageList); 		
		
	}	 			
	
	public static final String  CATALOG_OF_NEW_PRODUCT ="new_product.catalog";
	protected void checkCatalogIdOfNewProduct(PimUserContext userContext, String catalogId, List<Message> messageList)
	{
		
	 	checkIdOfNewProduct(userContext,catalogId, messageList); 		
		
	}	 			
	
	public static final String  PROFILE_OF_NEW_PRODUCT ="new_product.profile";
	protected void checkProfileIdOfNewProduct(PimUserContext userContext, String profileId, List<Message> messageList)
	{
		
	 	checkIdOfNewProduct(userContext,profileId, messageList); 		
		
	}	 			
	
	public static final String  REMARK_OF_NEW_PRODUCT ="new_product.remark";
	protected void checkRemarkOfNewProduct(PimUserContext userContext, String remark, List<Message> messageList)
	{
		
	 	checkStringLengthRange(remark,22, 336,REMARK_OF_NEW_PRODUCT, messageList); 		
		
	}	 			
	
	public static final String  PLATFORM_OF_NEW_PRODUCT ="new_product.platform";
	protected void checkPlatformIdOfNewProduct(PimUserContext userContext, String platformId, List<Message> messageList)
	{
		
	 	checkIdOfNewProduct(userContext,platformId, messageList); 		
		
	}	 			
	
	public static final String  VERSION_OF_NEW_PRODUCT ="new_product.version";
	protected void checkVersionOfNewProduct(PimUserContext userContext, int version, List<Message> messageList)
	{
		
	 	checkIntegerRange(version,0, Integer.MAX_VALUE,VERSION_OF_NEW_PRODUCT, messageList); 		
		
	}	 			
	
	public static final String  ID_OF_EDITOR_PICK_PRODUCT ="editor_pick_product.id";
	protected void checkIdOfEditorPickProduct(PimUserContext userContext, String id, List<Message> messageList)
	{
		
	 	checkStringLengthRange(id,5, 64,ID_OF_EDITOR_PICK_PRODUCT, messageList); 		
		
	}	 			
	
	public static final String  NAME_OF_EDITOR_PICK_PRODUCT ="editor_pick_product.name";
	protected void checkNameOfEditorPickProduct(PimUserContext userContext, String name, List<Message> messageList)
	{
		
	 	checkStringLengthRange(name,2, 20,NAME_OF_EDITOR_PICK_PRODUCT, messageList); 		
		
	}	 			
	
	public static final String  PARENT_CATEGORY_OF_EDITOR_PICK_PRODUCT ="editor_pick_product.parent_category";
	protected void checkParentCategoryIdOfEditorPickProduct(PimUserContext userContext, String parentCategoryId, List<Message> messageList)
	{
		
	 	checkIdOfEditorPickProduct(userContext,parentCategoryId, messageList); 		
		
	}	 			
	
	public static final String  BRAND_OF_EDITOR_PICK_PRODUCT ="editor_pick_product.brand";
	protected void checkBrandIdOfEditorPickProduct(PimUserContext userContext, String brandId, List<Message> messageList)
	{
		
	 	checkIdOfEditorPickProduct(userContext,brandId, messageList); 		
		
	}	 			
	
	public static final String  PRODUCT_COVER_IMAGE_OF_EDITOR_PICK_PRODUCT ="editor_pick_product.product_cover_image";
	protected void checkProductCoverImageOfEditorPickProduct(PimUserContext userContext, String productCoverImage, List<Message> messageList)
	{
		
	 	checkImage(productCoverImage,0, 512,PRODUCT_COVER_IMAGE_OF_EDITOR_PICK_PRODUCT, messageList); 		
		
	}	 			
	
	public static final String  ORIGIN_OF_EDITOR_PICK_PRODUCT ="editor_pick_product.origin";
	protected void checkOriginOfEditorPickProduct(PimUserContext userContext, String origin, List<Message> messageList)
	{
		
	 	checkStringLengthRange(origin,1, 24,ORIGIN_OF_EDITOR_PICK_PRODUCT, messageList); 		
		
	}	 			
	
	public static final String  CATALOG_OF_EDITOR_PICK_PRODUCT ="editor_pick_product.catalog";
	protected void checkCatalogIdOfEditorPickProduct(PimUserContext userContext, String catalogId, List<Message> messageList)
	{
		
	 	checkIdOfEditorPickProduct(userContext,catalogId, messageList); 		
		
	}	 			
	
	public static final String  PROFILE_OF_EDITOR_PICK_PRODUCT ="editor_pick_product.profile";
	protected void checkProfileIdOfEditorPickProduct(PimUserContext userContext, String profileId, List<Message> messageList)
	{
		
	 	checkIdOfEditorPickProduct(userContext,profileId, messageList); 		
		
	}	 			
	
	public static final String  REMARK_OF_EDITOR_PICK_PRODUCT ="editor_pick_product.remark";
	protected void checkRemarkOfEditorPickProduct(PimUserContext userContext, String remark, List<Message> messageList)
	{
		
	 	checkStringLengthRange(remark,22, 336,REMARK_OF_EDITOR_PICK_PRODUCT, messageList); 		
		
	}	 			
	
	public static final String  PLATFORM_OF_EDITOR_PICK_PRODUCT ="editor_pick_product.platform";
	protected void checkPlatformIdOfEditorPickProduct(PimUserContext userContext, String platformId, List<Message> messageList)
	{
		
	 	checkIdOfEditorPickProduct(userContext,platformId, messageList); 		
		
	}	 			
	
	public static final String  VERSION_OF_EDITOR_PICK_PRODUCT ="editor_pick_product.version";
	protected void checkVersionOfEditorPickProduct(PimUserContext userContext, int version, List<Message> messageList)
	{
		
	 	checkIntegerRange(version,0, Integer.MAX_VALUE,VERSION_OF_EDITOR_PICK_PRODUCT, messageList); 		
		
	}	 			
	
	public static final String  ID_OF_TOP_RATED_PRODUCT ="top_rated_product.id";
	protected void checkIdOfTopRatedProduct(PimUserContext userContext, String id, List<Message> messageList)
	{
		
	 	checkStringLengthRange(id,5, 64,ID_OF_TOP_RATED_PRODUCT, messageList); 		
		
	}	 			
	
	public static final String  NAME_OF_TOP_RATED_PRODUCT ="top_rated_product.name";
	protected void checkNameOfTopRatedProduct(PimUserContext userContext, String name, List<Message> messageList)
	{
		
	 	checkStringLengthRange(name,2, 20,NAME_OF_TOP_RATED_PRODUCT, messageList); 		
		
	}	 			
	
	public static final String  PARENT_CATEGORY_OF_TOP_RATED_PRODUCT ="top_rated_product.parent_category";
	protected void checkParentCategoryIdOfTopRatedProduct(PimUserContext userContext, String parentCategoryId, List<Message> messageList)
	{
		
	 	checkIdOfTopRatedProduct(userContext,parentCategoryId, messageList); 		
		
	}	 			
	
	public static final String  BRAND_OF_TOP_RATED_PRODUCT ="top_rated_product.brand";
	protected void checkBrandIdOfTopRatedProduct(PimUserContext userContext, String brandId, List<Message> messageList)
	{
		
	 	checkIdOfTopRatedProduct(userContext,brandId, messageList); 		
		
	}	 			
	
	public static final String  PRODUCT_COVER_IMAGE_OF_TOP_RATED_PRODUCT ="top_rated_product.product_cover_image";
	protected void checkProductCoverImageOfTopRatedProduct(PimUserContext userContext, String productCoverImage, List<Message> messageList)
	{
		
	 	checkImage(productCoverImage,0, 512,PRODUCT_COVER_IMAGE_OF_TOP_RATED_PRODUCT, messageList); 		
		
	}	 			
	
	public static final String  ORIGIN_OF_TOP_RATED_PRODUCT ="top_rated_product.origin";
	protected void checkOriginOfTopRatedProduct(PimUserContext userContext, String origin, List<Message> messageList)
	{
		
	 	checkStringLengthRange(origin,1, 24,ORIGIN_OF_TOP_RATED_PRODUCT, messageList); 		
		
	}	 			
	
	public static final String  CATALOG_OF_TOP_RATED_PRODUCT ="top_rated_product.catalog";
	protected void checkCatalogIdOfTopRatedProduct(PimUserContext userContext, String catalogId, List<Message> messageList)
	{
		
	 	checkIdOfTopRatedProduct(userContext,catalogId, messageList); 		
		
	}	 			
	
	public static final String  REMARK_OF_TOP_RATED_PRODUCT ="top_rated_product.remark";
	protected void checkRemarkOfTopRatedProduct(PimUserContext userContext, String remark, List<Message> messageList)
	{
		
	 	checkStringLengthRange(remark,22, 336,REMARK_OF_TOP_RATED_PRODUCT, messageList); 		
		
	}	 			
	
	public static final String  PROFILE_OF_TOP_RATED_PRODUCT ="top_rated_product.profile";
	protected void checkProfileIdOfTopRatedProduct(PimUserContext userContext, String profileId, List<Message> messageList)
	{
		
	 	checkIdOfTopRatedProduct(userContext,profileId, messageList); 		
		
	}	 			
	
	public static final String  PLATFORM_OF_TOP_RATED_PRODUCT ="top_rated_product.platform";
	protected void checkPlatformIdOfTopRatedProduct(PimUserContext userContext, String platformId, List<Message> messageList)
	{
		
	 	checkIdOfTopRatedProduct(userContext,platformId, messageList); 		
		
	}	 			
	
	public static final String  VERSION_OF_TOP_RATED_PRODUCT ="top_rated_product.version";
	protected void checkVersionOfTopRatedProduct(PimUserContext userContext, int version, List<Message> messageList)
	{
		
	 	checkIntegerRange(version,0, Integer.MAX_VALUE,VERSION_OF_TOP_RATED_PRODUCT, messageList); 		
		
	}	 			
	
	public static final String  ID_OF_RECOMMAND_PRODUCT ="recommand_product.id";
	protected void checkIdOfRecommandProduct(PimUserContext userContext, String id, List<Message> messageList)
	{
		
	 	checkStringLengthRange(id,5, 64,ID_OF_RECOMMAND_PRODUCT, messageList); 		
		
	}	 			
	
	public static final String  NAME_OF_RECOMMAND_PRODUCT ="recommand_product.name";
	protected void checkNameOfRecommandProduct(PimUserContext userContext, String name, List<Message> messageList)
	{
		
	 	checkStringLengthRange(name,2, 20,NAME_OF_RECOMMAND_PRODUCT, messageList); 		
		
	}	 			
	
	public static final String  PARENT_CATEGORY_OF_RECOMMAND_PRODUCT ="recommand_product.parent_category";
	protected void checkParentCategoryIdOfRecommandProduct(PimUserContext userContext, String parentCategoryId, List<Message> messageList)
	{
		
	 	checkIdOfRecommandProduct(userContext,parentCategoryId, messageList); 		
		
	}	 			
	
	public static final String  BRAND_OF_RECOMMAND_PRODUCT ="recommand_product.brand";
	protected void checkBrandIdOfRecommandProduct(PimUserContext userContext, String brandId, List<Message> messageList)
	{
		
	 	checkIdOfRecommandProduct(userContext,brandId, messageList); 		
		
	}	 			
	
	public static final String  PRODUCT_COVER_IMAGE_OF_RECOMMAND_PRODUCT ="recommand_product.product_cover_image";
	protected void checkProductCoverImageOfRecommandProduct(PimUserContext userContext, String productCoverImage, List<Message> messageList)
	{
		
	 	checkImage(productCoverImage,0, 512,PRODUCT_COVER_IMAGE_OF_RECOMMAND_PRODUCT, messageList); 		
		
	}	 			
	
	public static final String  ORIGIN_OF_RECOMMAND_PRODUCT ="recommand_product.origin";
	protected void checkOriginOfRecommandProduct(PimUserContext userContext, String origin, List<Message> messageList)
	{
		
	 	checkStringLengthRange(origin,1, 24,ORIGIN_OF_RECOMMAND_PRODUCT, messageList); 		
		
	}	 			
	
	public static final String  CATALOG_OF_RECOMMAND_PRODUCT ="recommand_product.catalog";
	protected void checkCatalogIdOfRecommandProduct(PimUserContext userContext, String catalogId, List<Message> messageList)
	{
		
	 	checkIdOfRecommandProduct(userContext,catalogId, messageList); 		
		
	}	 			
	
	public static final String  REMARK_OF_RECOMMAND_PRODUCT ="recommand_product.remark";
	protected void checkRemarkOfRecommandProduct(PimUserContext userContext, String remark, List<Message> messageList)
	{
		
	 	checkStringLengthRange(remark,22, 336,REMARK_OF_RECOMMAND_PRODUCT, messageList); 		
		
	}	 			
	
	public static final String  PROFILE_OF_RECOMMAND_PRODUCT ="recommand_product.profile";
	protected void checkProfileIdOfRecommandProduct(PimUserContext userContext, String profileId, List<Message> messageList)
	{
		
	 	checkIdOfRecommandProduct(userContext,profileId, messageList); 		
		
	}	 			
	
	public static final String  PLATFORM_OF_RECOMMAND_PRODUCT ="recommand_product.platform";
	protected void checkPlatformIdOfRecommandProduct(PimUserContext userContext, String platformId, List<Message> messageList)
	{
		
	 	checkIdOfRecommandProduct(userContext,platformId, messageList); 		
		
	}	 			
	
	public static final String  VERSION_OF_RECOMMAND_PRODUCT ="recommand_product.version";
	protected void checkVersionOfRecommandProduct(PimUserContext userContext, int version, List<Message> messageList)
	{
		
	 	checkIntegerRange(version,0, Integer.MAX_VALUE,VERSION_OF_RECOMMAND_PRODUCT, messageList); 		
		
	}	 			
	
	public static final String  ID_OF_USER_DOMAIN ="user_domain.id";
	protected void checkIdOfUserDomain(PimUserContext userContext, String id, List<Message> messageList)
	{
		
	 	checkStringLengthRange(id,5, 64,ID_OF_USER_DOMAIN, messageList); 		
		
	}	 			
	
	public static final String  NAME_OF_USER_DOMAIN ="user_domain.name";
	protected void checkNameOfUserDomain(PimUserContext userContext, String name, List<Message> messageList)
	{
		
	 	checkStringLengthRange(name,2, 16,NAME_OF_USER_DOMAIN, messageList); 		
		
	}	 			
	
	public static final String  VERSION_OF_USER_DOMAIN ="user_domain.version";
	protected void checkVersionOfUserDomain(PimUserContext userContext, int version, List<Message> messageList)
	{
		
	 	checkIntegerRange(version,0, Integer.MAX_VALUE,VERSION_OF_USER_DOMAIN, messageList); 		
		
	}	 			
	
	public static final String  ID_OF_USER_WHITE_LIST ="user_white_list.id";
	protected void checkIdOfUserWhiteList(PimUserContext userContext, String id, List<Message> messageList)
	{
		
	 	checkStringLengthRange(id,5, 64,ID_OF_USER_WHITE_LIST, messageList); 		
		
	}	 			
	
	public static final String  USER_IDENTITY_OF_USER_WHITE_LIST ="user_white_list.user_identity";
	protected void checkUserIdentityOfUserWhiteList(PimUserContext userContext, String userIdentity, List<Message> messageList)
	{
		
	 	checkStringLengthRange(userIdentity,1, 40,USER_IDENTITY_OF_USER_WHITE_LIST, messageList); 		
		
	}	 			
	
	public static final String  USER_SPECIAL_FUNCTIONS_OF_USER_WHITE_LIST ="user_white_list.user_special_functions";
	protected void checkUserSpecialFunctionsOfUserWhiteList(PimUserContext userContext, String userSpecialFunctions, List<Message> messageList)
	{
		
	 	checkStringLengthRange(userSpecialFunctions,1, 200,USER_SPECIAL_FUNCTIONS_OF_USER_WHITE_LIST, messageList); 		
		
	}	 			
	
	public static final String  DOMAIN_OF_USER_WHITE_LIST ="user_white_list.domain";
	protected void checkDomainIdOfUserWhiteList(PimUserContext userContext, String domainId, List<Message> messageList)
	{
		
	 	checkIdOfUserWhiteList(userContext,domainId, messageList); 		
		
	}	 			
	
	public static final String  VERSION_OF_USER_WHITE_LIST ="user_white_list.version";
	protected void checkVersionOfUserWhiteList(PimUserContext userContext, int version, List<Message> messageList)
	{
		
	 	checkIntegerRange(version,0, Integer.MAX_VALUE,VERSION_OF_USER_WHITE_LIST, messageList); 		
		
	}	 			
	
	public static final String  ID_OF_SEC_USER ="sec_user.id";
	protected void checkIdOfSecUser(PimUserContext userContext, String id, List<Message> messageList)
	{
		
	 	checkStringLengthRange(id,5, 64,ID_OF_SEC_USER, messageList); 		
		
	}	 			
	
	public static final String  LOGIN_OF_SEC_USER ="sec_user.login";
	protected void checkLoginOfSecUser(PimUserContext userContext, String login, List<Message> messageList)
	{
		
	 	checkStringLengthRange(login,2, 20,LOGIN_OF_SEC_USER, messageList); 		
		
	}	 			
	
	public static final String  MOBILE_OF_SEC_USER ="sec_user.mobile";
	protected void checkMobileOfSecUser(PimUserContext userContext, String mobile, List<Message> messageList)
	{
		
	 	checkChinaMobilePhone(mobile,0, 11,MOBILE_OF_SEC_USER, messageList); 		
		
	}	 			
	
	public static final String  EMAIL_OF_SEC_USER ="sec_user.email";
	protected void checkEmailOfSecUser(PimUserContext userContext, String email, List<Message> messageList)
	{
		
	 	checkStringLengthRange(email,0, 76,EMAIL_OF_SEC_USER, messageList); 		
		
	}	 			
	
	public static final String  PWD_OF_SEC_USER ="sec_user.pwd";
	protected void checkPwdOfSecUser(PimUserContext userContext, String pwd, List<Message> messageList)
	{
		
	 	checkPassword(pwd,3, 28,PWD_OF_SEC_USER, messageList); 		
		
	}	 			
	
	public static final String  VERIFICATION_CODE_OF_SEC_USER ="sec_user.verification_code";
	protected void checkVerificationCodeOfSecUser(PimUserContext userContext, int verificationCode, List<Message> messageList)
	{
		
	 	checkIntegerRange(verificationCode,0, 9999999,VERIFICATION_CODE_OF_SEC_USER, messageList); 		
		
	}	 			
	
	public static final String  VERIFICATION_CODE_EXPIRE_OF_SEC_USER ="sec_user.verification_code_expire";
	protected void checkVerificationCodeExpireOfSecUser(PimUserContext userContext, DateTime verificationCodeExpire, List<Message> messageList)
	{
		
	 	checkDateTime(verificationCodeExpire,parseTimestamp("1900-01-01T00:00:00"), parseTimestamp("2099-12-31T09:09:09"),VERIFICATION_CODE_EXPIRE_OF_SEC_USER, messageList); 		
		
	}	 			
	
	public static final String  LAST_LOGIN_TIME_OF_SEC_USER ="sec_user.last_login_time";
	protected void checkLastLoginTimeOfSecUser(PimUserContext userContext, DateTime lastLoginTime, List<Message> messageList)
	{
		
	 	checkDateTime(lastLoginTime,parseTimestamp("1900-01-01T00:00:00"), parseTimestamp("2099-12-31T09:09:09"),LAST_LOGIN_TIME_OF_SEC_USER, messageList); 		
		
	}	 			
	
	public static final String  DOMAIN_OF_SEC_USER ="sec_user.domain";
	protected void checkDomainIdOfSecUser(PimUserContext userContext, String domainId, List<Message> messageList)
	{
		
	 	checkIdOfSecUser(userContext,domainId, messageList); 		
		
	}	 			
	
	public static final String  VERSION_OF_SEC_USER ="sec_user.version";
	protected void checkVersionOfSecUser(PimUserContext userContext, int version, List<Message> messageList)
	{
		
	 	checkIntegerRange(version,0, Integer.MAX_VALUE,VERSION_OF_SEC_USER, messageList); 		
		
	}	 			
	
	public static final String  ID_OF_SEC_USER_BLOCKING ="sec_user_blocking.id";
	protected void checkIdOfSecUserBlocking(PimUserContext userContext, String id, List<Message> messageList)
	{
		
	 	checkStringLengthRange(id,5, 64,ID_OF_SEC_USER_BLOCKING, messageList); 		
		
	}	 			
	
	public static final String  WHO_OF_SEC_USER_BLOCKING ="sec_user_blocking.who";
	protected void checkWhoOfSecUserBlocking(PimUserContext userContext, String who, List<Message> messageList)
	{
		
	 	checkStringLengthRange(who,4, 52,WHO_OF_SEC_USER_BLOCKING, messageList); 		
		
	}	 			
	
	public static final String  COMMENTS_OF_SEC_USER_BLOCKING ="sec_user_blocking.comments";
	protected void checkCommentsOfSecUserBlocking(PimUserContext userContext, String comments, List<Message> messageList)
	{
		
	 	checkStringLengthRange(comments,7, 96,COMMENTS_OF_SEC_USER_BLOCKING, messageList); 		
		
	}	 			
	
	public static final String  VERSION_OF_SEC_USER_BLOCKING ="sec_user_blocking.version";
	protected void checkVersionOfSecUserBlocking(PimUserContext userContext, int version, List<Message> messageList)
	{
		
	 	checkIntegerRange(version,0, Integer.MAX_VALUE,VERSION_OF_SEC_USER_BLOCKING, messageList); 		
		
	}	 			
	
	public static final String  ID_OF_USER_APP ="user_app.id";
	protected void checkIdOfUserApp(PimUserContext userContext, String id, List<Message> messageList)
	{
		
	 	checkStringLengthRange(id,5, 64,ID_OF_USER_APP, messageList); 		
		
	}	 			
	
	public static final String  TITLE_OF_USER_APP ="user_app.title";
	protected void checkTitleOfUserApp(PimUserContext userContext, String title, List<Message> messageList)
	{
		
	 	checkStringLengthRange(title,1, 300,TITLE_OF_USER_APP, messageList); 		
		
	}	 			
	
	public static final String  SEC_USER_OF_USER_APP ="user_app.sec_user";
	protected void checkSecUserIdOfUserApp(PimUserContext userContext, String secUserId, List<Message> messageList)
	{
		
	 	checkIdOfUserApp(userContext,secUserId, messageList); 		
		
	}	 			
	
	public static final String  APP_ICON_OF_USER_APP ="user_app.app_icon";
	protected void checkAppIconOfUserApp(PimUserContext userContext, String appIcon, List<Message> messageList)
	{
		
	 	checkStringLengthRange(appIcon,2, 36,APP_ICON_OF_USER_APP, messageList); 		
		
	}	 			
	
	public static final String  FULL_ACCESS_OF_USER_APP ="user_app.full_access";
	protected void checkFullAccessOfUserApp(PimUserContext userContext, boolean fullAccess, List<Message> messageList)
	{
		
	 	checkBooleanRange(fullAccess,0, true,FULL_ACCESS_OF_USER_APP, messageList); 		
		
	}	 			
	
	public static final String  PERMISSION_OF_USER_APP ="user_app.permission";
	protected void checkPermissionOfUserApp(PimUserContext userContext, String permission, List<Message> messageList)
	{
		
	 	checkStringLengthRange(permission,2, 16,PERMISSION_OF_USER_APP, messageList); 		
		
	}	 			
	
	public static final String  OBJECT_TYPE_OF_USER_APP ="user_app.object_type";
	protected void checkObjectTypeOfUserApp(PimUserContext userContext, String objectType, List<Message> messageList)
	{
		
	 	checkStringLengthRange(objectType,5, 108,OBJECT_TYPE_OF_USER_APP, messageList); 		
		
	}	 			
	
	public static final String  OBJECT_ID_OF_USER_APP ="user_app.object_id";
	protected void checkObjectIdOfUserApp(PimUserContext userContext, String objectId, List<Message> messageList)
	{
		
	 	checkStringLengthRange(objectId,4, 40,OBJECT_ID_OF_USER_APP, messageList); 		
		
	}	 			
	
	public static final String  LOCATION_OF_USER_APP ="user_app.location";
	protected void checkLocationOfUserApp(PimUserContext userContext, String location, List<Message> messageList)
	{
		
	 	checkStringLengthRange(location,4, 48,LOCATION_OF_USER_APP, messageList); 		
		
	}	 			
	
	public static final String  VERSION_OF_USER_APP ="user_app.version";
	protected void checkVersionOfUserApp(PimUserContext userContext, int version, List<Message> messageList)
	{
		
	 	checkIntegerRange(version,0, Integer.MAX_VALUE,VERSION_OF_USER_APP, messageList); 		
		
	}	 			
	
	public static final String  ID_OF_LIST_ACCESS ="list_access.id";
	protected void checkIdOfListAccess(PimUserContext userContext, String id, List<Message> messageList)
	{
		
	 	checkStringLengthRange(id,5, 64,ID_OF_LIST_ACCESS, messageList); 		
		
	}	 			
	
	public static final String  NAME_OF_LIST_ACCESS ="list_access.name";
	protected void checkNameOfListAccess(PimUserContext userContext, String name, List<Message> messageList)
	{
		
	 	checkStringLengthRange(name,2, 200,NAME_OF_LIST_ACCESS, messageList); 		
		
	}	 			
	
	public static final String  INTERNAL_NAME_OF_LIST_ACCESS ="list_access.internal_name";
	protected void checkInternalNameOfListAccess(PimUserContext userContext, String internalName, List<Message> messageList)
	{
		
	 	checkStringLengthRange(internalName,2, 200,INTERNAL_NAME_OF_LIST_ACCESS, messageList); 		
		
	}	 			
	
	public static final String  READ_PERMISSION_OF_LIST_ACCESS ="list_access.read_permission";
	protected void checkReadPermissionOfListAccess(PimUserContext userContext, boolean readPermission, List<Message> messageList)
	{
		
	 	checkBooleanRange(readPermission,0, true,READ_PERMISSION_OF_LIST_ACCESS, messageList); 		
		
	}	 			
	
	public static final String  CREATE_PERMISSION_OF_LIST_ACCESS ="list_access.create_permission";
	protected void checkCreatePermissionOfListAccess(PimUserContext userContext, boolean createPermission, List<Message> messageList)
	{
		
	 	checkBooleanRange(createPermission,0, true,CREATE_PERMISSION_OF_LIST_ACCESS, messageList); 		
		
	}	 			
	
	public static final String  DELETE_PERMISSION_OF_LIST_ACCESS ="list_access.delete_permission";
	protected void checkDeletePermissionOfListAccess(PimUserContext userContext, boolean deletePermission, List<Message> messageList)
	{
		
	 	checkBooleanRange(deletePermission,0, true,DELETE_PERMISSION_OF_LIST_ACCESS, messageList); 		
		
	}	 			
	
	public static final String  UPDATE_PERMISSION_OF_LIST_ACCESS ="list_access.update_permission";
	protected void checkUpdatePermissionOfListAccess(PimUserContext userContext, boolean updatePermission, List<Message> messageList)
	{
		
	 	checkBooleanRange(updatePermission,0, true,UPDATE_PERMISSION_OF_LIST_ACCESS, messageList); 		
		
	}	 			
	
	public static final String  EXECUTION_PERMISSION_OF_LIST_ACCESS ="list_access.execution_permission";
	protected void checkExecutionPermissionOfListAccess(PimUserContext userContext, boolean executionPermission, List<Message> messageList)
	{
		
	 	checkBooleanRange(executionPermission,0, true,EXECUTION_PERMISSION_OF_LIST_ACCESS, messageList); 		
		
	}	 			
	
	public static final String  APP_OF_LIST_ACCESS ="list_access.app";
	protected void checkAppIdOfListAccess(PimUserContext userContext, String appId, List<Message> messageList)
	{
		
	 	checkIdOfListAccess(userContext,appId, messageList); 		
		
	}	 			
	
	public static final String  VERSION_OF_LIST_ACCESS ="list_access.version";
	protected void checkVersionOfListAccess(PimUserContext userContext, int version, List<Message> messageList)
	{
		
	 	checkIntegerRange(version,0, Integer.MAX_VALUE,VERSION_OF_LIST_ACCESS, messageList); 		
		
	}	 			
	
	public static final String  ID_OF_OBJECT_ACCESS ="object_access.id";
	protected void checkIdOfObjectAccess(PimUserContext userContext, String id, List<Message> messageList)
	{
		
	 	checkStringLengthRange(id,5, 64,ID_OF_OBJECT_ACCESS, messageList); 		
		
	}	 			
	
	public static final String  NAME_OF_OBJECT_ACCESS ="object_access.name";
	protected void checkNameOfObjectAccess(PimUserContext userContext, String name, List<Message> messageList)
	{
		
	 	checkStringLengthRange(name,2, 28,NAME_OF_OBJECT_ACCESS, messageList); 		
		
	}	 			
	
	public static final String  OBJECT_TYPE_OF_OBJECT_ACCESS ="object_access.object_type";
	protected void checkObjectTypeOfObjectAccess(PimUserContext userContext, String objectType, List<Message> messageList)
	{
		
	 	checkStringLengthRange(objectType,5, 112,OBJECT_TYPE_OF_OBJECT_ACCESS, messageList); 		
		
	}	 			
	
	public static final String  LIST1_OF_OBJECT_ACCESS ="object_access.list1";
	protected void checkList1OfObjectAccess(PimUserContext userContext, String list1, List<Message> messageList)
	{
		
	 	checkStringLengthRange(list1,5, 80,LIST1_OF_OBJECT_ACCESS, messageList); 		
		
	}	 			
	
	public static final String  LIST2_OF_OBJECT_ACCESS ="object_access.list2";
	protected void checkList2OfObjectAccess(PimUserContext userContext, String list2, List<Message> messageList)
	{
		
	 	checkStringLengthRange(list2,5, 80,LIST2_OF_OBJECT_ACCESS, messageList); 		
		
	}	 			
	
	public static final String  LIST3_OF_OBJECT_ACCESS ="object_access.list3";
	protected void checkList3OfObjectAccess(PimUserContext userContext, String list3, List<Message> messageList)
	{
		
	 	checkStringLengthRange(list3,5, 80,LIST3_OF_OBJECT_ACCESS, messageList); 		
		
	}	 			
	
	public static final String  LIST4_OF_OBJECT_ACCESS ="object_access.list4";
	protected void checkList4OfObjectAccess(PimUserContext userContext, String list4, List<Message> messageList)
	{
		
	 	checkStringLengthRange(list4,5, 80,LIST4_OF_OBJECT_ACCESS, messageList); 		
		
	}	 			
	
	public static final String  LIST5_OF_OBJECT_ACCESS ="object_access.list5";
	protected void checkList5OfObjectAccess(PimUserContext userContext, String list5, List<Message> messageList)
	{
		
	 	checkStringLengthRange(list5,5, 80,LIST5_OF_OBJECT_ACCESS, messageList); 		
		
	}	 			
	
	public static final String  LIST6_OF_OBJECT_ACCESS ="object_access.list6";
	protected void checkList6OfObjectAccess(PimUserContext userContext, String list6, List<Message> messageList)
	{
		
	 	checkStringLengthRange(list6,5, 80,LIST6_OF_OBJECT_ACCESS, messageList); 		
		
	}	 			
	
	public static final String  LIST7_OF_OBJECT_ACCESS ="object_access.list7";
	protected void checkList7OfObjectAccess(PimUserContext userContext, String list7, List<Message> messageList)
	{
		
	 	checkStringLengthRange(list7,5, 80,LIST7_OF_OBJECT_ACCESS, messageList); 		
		
	}	 			
	
	public static final String  LIST8_OF_OBJECT_ACCESS ="object_access.list8";
	protected void checkList8OfObjectAccess(PimUserContext userContext, String list8, List<Message> messageList)
	{
		
	 	checkStringLengthRange(list8,5, 80,LIST8_OF_OBJECT_ACCESS, messageList); 		
		
	}	 			
	
	public static final String  LIST9_OF_OBJECT_ACCESS ="object_access.list9";
	protected void checkList9OfObjectAccess(PimUserContext userContext, String list9, List<Message> messageList)
	{
		
	 	checkStringLengthRange(list9,5, 80,LIST9_OF_OBJECT_ACCESS, messageList); 		
		
	}	 			
	
	public static final String  APP_OF_OBJECT_ACCESS ="object_access.app";
	protected void checkAppIdOfObjectAccess(PimUserContext userContext, String appId, List<Message> messageList)
	{
		
	 	checkIdOfObjectAccess(userContext,appId, messageList); 		
		
	}	 			
	
	public static final String  VERSION_OF_OBJECT_ACCESS ="object_access.version";
	protected void checkVersionOfObjectAccess(PimUserContext userContext, int version, List<Message> messageList)
	{
		
	 	checkIntegerRange(version,0, Integer.MAX_VALUE,VERSION_OF_OBJECT_ACCESS, messageList); 		
		
	}	 			
	
	public static final String  ID_OF_LOGIN_HISTORY ="login_history.id";
	protected void checkIdOfLoginHistory(PimUserContext userContext, String id, List<Message> messageList)
	{
		
	 	checkStringLengthRange(id,5, 64,ID_OF_LOGIN_HISTORY, messageList); 		
		
	}	 			
	
	public static final String  FROM_IP_OF_LOGIN_HISTORY ="login_history.from_ip";
	protected void checkFromIpOfLoginHistory(PimUserContext userContext, String fromIp, List<Message> messageList)
	{
		
	 	checkStringLengthRange(fromIp,5, 44,FROM_IP_OF_LOGIN_HISTORY, messageList); 		
		
	}	 			
	
	public static final String  DESCRIPTION_OF_LOGIN_HISTORY ="login_history.description";
	protected void checkDescriptionOfLoginHistory(PimUserContext userContext, String description, List<Message> messageList)
	{
		
	 	checkStringLengthRange(description,2, 16,DESCRIPTION_OF_LOGIN_HISTORY, messageList); 		
		
	}	 			
	
	public static final String  SEC_USER_OF_LOGIN_HISTORY ="login_history.sec_user";
	protected void checkSecUserIdOfLoginHistory(PimUserContext userContext, String secUserId, List<Message> messageList)
	{
		
	 	checkIdOfLoginHistory(userContext,secUserId, messageList); 		
		
	}	 			
	
	public static final String  VERSION_OF_LOGIN_HISTORY ="login_history.version";
	protected void checkVersionOfLoginHistory(PimUserContext userContext, int version, List<Message> messageList)
	{
		
	 	checkIntegerRange(version,0, Integer.MAX_VALUE,VERSION_OF_LOGIN_HISTORY, messageList); 		
		
	}	 			
	
	public static final String  ID_OF_GENERIC_FORM ="generic_form.id";
	protected void checkIdOfGenericForm(PimUserContext userContext, String id, List<Message> messageList)
	{
		
	 	checkStringLengthRange(id,5, 64,ID_OF_GENERIC_FORM, messageList); 		
		
	}	 			
	
	public static final String  TITLE_OF_GENERIC_FORM ="generic_form.title";
	protected void checkTitleOfGenericForm(PimUserContext userContext, String title, List<Message> messageList)
	{
		
	 	checkStringLengthRange(title,2, 20,TITLE_OF_GENERIC_FORM, messageList); 		
		
	}	 			
	
	public static final String  DESCRIPTION_OF_GENERIC_FORM ="generic_form.description";
	protected void checkDescriptionOfGenericForm(PimUserContext userContext, String description, List<Message> messageList)
	{
		
	 	checkStringLengthRange(description,4, 48,DESCRIPTION_OF_GENERIC_FORM, messageList); 		
		
	}	 			
	
	public static final String  VERSION_OF_GENERIC_FORM ="generic_form.version";
	protected void checkVersionOfGenericForm(PimUserContext userContext, int version, List<Message> messageList)
	{
		
	 	checkIntegerRange(version,0, Integer.MAX_VALUE,VERSION_OF_GENERIC_FORM, messageList); 		
		
	}	 			
	
	public static final String  ID_OF_FORM_MESSAGE ="form_message.id";
	protected void checkIdOfFormMessage(PimUserContext userContext, String id, List<Message> messageList)
	{
		
	 	checkStringLengthRange(id,5, 64,ID_OF_FORM_MESSAGE, messageList); 		
		
	}	 			
	
	public static final String  TITLE_OF_FORM_MESSAGE ="form_message.title";
	protected void checkTitleOfFormMessage(PimUserContext userContext, String title, List<Message> messageList)
	{
		
	 	checkStringLengthRange(title,2, 24,TITLE_OF_FORM_MESSAGE, messageList); 		
		
	}	 			
	
	public static final String  FORM_OF_FORM_MESSAGE ="form_message.form";
	protected void checkFormIdOfFormMessage(PimUserContext userContext, String formId, List<Message> messageList)
	{
		
	 	checkIdOfFormMessage(userContext,formId, messageList); 		
		
	}	 			
	
	public static final String  LEVEL_OF_FORM_MESSAGE ="form_message.level";
	protected void checkLevelOfFormMessage(PimUserContext userContext, String level, List<Message> messageList)
	{
		
	 	checkStringLengthRange(level,2, 28,LEVEL_OF_FORM_MESSAGE, messageList); 		
		
	}	 			
	
	public static final String  VERSION_OF_FORM_MESSAGE ="form_message.version";
	protected void checkVersionOfFormMessage(PimUserContext userContext, int version, List<Message> messageList)
	{
		
	 	checkIntegerRange(version,0, Integer.MAX_VALUE,VERSION_OF_FORM_MESSAGE, messageList); 		
		
	}	 			
	
	public static final String  ID_OF_FORM_FIELD_MESSAGE ="form_field_message.id";
	protected void checkIdOfFormFieldMessage(PimUserContext userContext, String id, List<Message> messageList)
	{
		
	 	checkStringLengthRange(id,5, 64,ID_OF_FORM_FIELD_MESSAGE, messageList); 		
		
	}	 			
	
	public static final String  TITLE_OF_FORM_FIELD_MESSAGE ="form_field_message.title";
	protected void checkTitleOfFormFieldMessage(PimUserContext userContext, String title, List<Message> messageList)
	{
		
	 	checkStringLengthRange(title,2, 16,TITLE_OF_FORM_FIELD_MESSAGE, messageList); 		
		
	}	 			
	
	public static final String  PARAMETER_NAME_OF_FORM_FIELD_MESSAGE ="form_field_message.parameter_name";
	protected void checkParameterNameOfFormFieldMessage(PimUserContext userContext, String parameterName, List<Message> messageList)
	{
		
	 	checkStringLengthRange(parameterName,2, 16,PARAMETER_NAME_OF_FORM_FIELD_MESSAGE, messageList); 		
		
	}	 			
	
	public static final String  FORM_OF_FORM_FIELD_MESSAGE ="form_field_message.form";
	protected void checkFormIdOfFormFieldMessage(PimUserContext userContext, String formId, List<Message> messageList)
	{
		
	 	checkIdOfFormFieldMessage(userContext,formId, messageList); 		
		
	}	 			
	
	public static final String  LEVEL_OF_FORM_FIELD_MESSAGE ="form_field_message.level";
	protected void checkLevelOfFormFieldMessage(PimUserContext userContext, String level, List<Message> messageList)
	{
		
	 	checkStringLengthRange(level,2, 28,LEVEL_OF_FORM_FIELD_MESSAGE, messageList); 		
		
	}	 			
	
	public static final String  VERSION_OF_FORM_FIELD_MESSAGE ="form_field_message.version";
	protected void checkVersionOfFormFieldMessage(PimUserContext userContext, int version, List<Message> messageList)
	{
		
	 	checkIntegerRange(version,0, Integer.MAX_VALUE,VERSION_OF_FORM_FIELD_MESSAGE, messageList); 		
		
	}	 			
	
	public static final String  ID_OF_FORM_FIELD ="form_field.id";
	protected void checkIdOfFormField(PimUserContext userContext, String id, List<Message> messageList)
	{
		
	 	checkStringLengthRange(id,5, 64,ID_OF_FORM_FIELD, messageList); 		
		
	}	 			
	
	public static final String  LABEL_OF_FORM_FIELD ="form_field.label";
	protected void checkLabelOfFormField(PimUserContext userContext, String label, List<Message> messageList)
	{
		
	 	checkStringLengthRange(label,1, 12,LABEL_OF_FORM_FIELD, messageList); 		
		
	}	 			
	
	public static final String  LOCALE_KEY_OF_FORM_FIELD ="form_field.locale_key";
	protected void checkLocaleKeyOfFormField(PimUserContext userContext, String localeKey, List<Message> messageList)
	{
		
	 	checkStringLengthRange(localeKey,1, 44,LOCALE_KEY_OF_FORM_FIELD, messageList); 		
		
	}	 			
	
	public static final String  PARAMETER_NAME_OF_FORM_FIELD ="form_field.parameter_name";
	protected void checkParameterNameOfFormField(PimUserContext userContext, String parameterName, List<Message> messageList)
	{
		
	 	checkStringLengthRange(parameterName,2, 16,PARAMETER_NAME_OF_FORM_FIELD, messageList); 		
		
	}	 			
	
	public static final String  TYPE_OF_FORM_FIELD ="form_field.type";
	protected void checkTypeOfFormField(PimUserContext userContext, String type, List<Message> messageList)
	{
		
	 	checkStringLengthRange(type,1, 36,TYPE_OF_FORM_FIELD, messageList); 		
		
	}	 			
	
	public static final String  FORM_OF_FORM_FIELD ="form_field.form";
	protected void checkFormIdOfFormField(PimUserContext userContext, String formId, List<Message> messageList)
	{
		
	 	checkIdOfFormField(userContext,formId, messageList); 		
		
	}	 			
	
	public static final String  PLACEHOLDER_OF_FORM_FIELD ="form_field.placeholder";
	protected void checkPlaceholderOfFormField(PimUserContext userContext, String placeholder, List<Message> messageList)
	{
		
	 	checkStringLengthRange(placeholder,4, 48,PLACEHOLDER_OF_FORM_FIELD, messageList); 		
		
	}	 			
	
	public static final String  DEFAULT_VALUE_OF_FORM_FIELD ="form_field.default_value";
	protected void checkDefaultValueOfFormField(PimUserContext userContext, String defaultValue, List<Message> messageList)
	{
		
	 	checkStringLengthRange(defaultValue,1, 12,DEFAULT_VALUE_OF_FORM_FIELD, messageList); 		
		
	}	 			
	
	public static final String  DESCRIPTION_OF_FORM_FIELD ="form_field.description";
	protected void checkDescriptionOfFormField(PimUserContext userContext, String description, List<Message> messageList)
	{
		
	 	checkStringLengthRange(description,4, 48,DESCRIPTION_OF_FORM_FIELD, messageList); 		
		
	}	 			
	
	public static final String  FIELD_GROUP_OF_FORM_FIELD ="form_field.field_group";
	protected void checkFieldGroupOfFormField(PimUserContext userContext, String fieldGroup, List<Message> messageList)
	{
		
	 	checkStringLengthRange(fieldGroup,2, 16,FIELD_GROUP_OF_FORM_FIELD, messageList); 		
		
	}	 			
	
	public static final String  MINIMUM_VALUE_OF_FORM_FIELD ="form_field.minimum_value";
	protected void checkMinimumValueOfFormField(PimUserContext userContext, String minimumValue, List<Message> messageList)
	{
		
	 	checkStringLengthRange(minimumValue,4, 60,MINIMUM_VALUE_OF_FORM_FIELD, messageList); 		
		
	}	 			
	
	public static final String  MAXIMUM_VALUE_OF_FORM_FIELD ="form_field.maximum_value";
	protected void checkMaximumValueOfFormField(PimUserContext userContext, String maximumValue, List<Message> messageList)
	{
		
	 	checkStringLengthRange(maximumValue,5, 72,MAXIMUM_VALUE_OF_FORM_FIELD, messageList); 		
		
	}	 			
	
	public static final String  REQUIRED_OF_FORM_FIELD ="form_field.required";
	protected void checkRequiredOfFormField(PimUserContext userContext, boolean required, List<Message> messageList)
	{
		
	 	checkBooleanRange(required,0, true|false,REQUIRED_OF_FORM_FIELD, messageList); 		
		
	}	 			
	
	public static final String  DISABLED_OF_FORM_FIELD ="form_field.disabled";
	protected void checkDisabledOfFormField(PimUserContext userContext, boolean disabled, List<Message> messageList)
	{
		
	 	checkBooleanRange(disabled,0, true|false,DISABLED_OF_FORM_FIELD, messageList); 		
		
	}	 			
	
	public static final String  CUSTOM_RENDERING_OF_FORM_FIELD ="form_field.custom_rendering";
	protected void checkCustomRenderingOfFormField(PimUserContext userContext, boolean customRendering, List<Message> messageList)
	{
		
	 	checkBooleanRange(customRendering,0, false,CUSTOM_RENDERING_OF_FORM_FIELD, messageList); 		
		
	}	 			
	
	public static final String  CANDIDATE_VALUES_OF_FORM_FIELD ="form_field.candidate_values";
	protected void checkCandidateValuesOfFormField(PimUserContext userContext, String candidateValues, List<Message> messageList)
	{
		
	 	checkStringLengthRange(candidateValues,0, 12,CANDIDATE_VALUES_OF_FORM_FIELD, messageList); 		
		
	}	 			
	
	public static final String  SUGGEST_VALUES_OF_FORM_FIELD ="form_field.suggest_values";
	protected void checkSuggestValuesOfFormField(PimUserContext userContext, String suggestValues, List<Message> messageList)
	{
		
	 	checkStringLengthRange(suggestValues,0, 12,SUGGEST_VALUES_OF_FORM_FIELD, messageList); 		
		
	}	 			
	
	public static final String  VERSION_OF_FORM_FIELD ="form_field.version";
	protected void checkVersionOfFormField(PimUserContext userContext, int version, List<Message> messageList)
	{
		
	 	checkIntegerRange(version,0, Integer.MAX_VALUE,VERSION_OF_FORM_FIELD, messageList); 		
		
	}	 			
	
	public static final String  ID_OF_FORM_ACTION ="form_action.id";
	protected void checkIdOfFormAction(PimUserContext userContext, String id, List<Message> messageList)
	{
		
	 	checkStringLengthRange(id,5, 64,ID_OF_FORM_ACTION, messageList); 		
		
	}	 			
	
	public static final String  LABEL_OF_FORM_ACTION ="form_action.label";
	protected void checkLabelOfFormAction(PimUserContext userContext, String label, List<Message> messageList)
	{
		
	 	checkStringLengthRange(label,1, 8,LABEL_OF_FORM_ACTION, messageList); 		
		
	}	 			
	
	public static final String  LOCALE_KEY_OF_FORM_ACTION ="form_action.locale_key";
	protected void checkLocaleKeyOfFormAction(PimUserContext userContext, String localeKey, List<Message> messageList)
	{
		
	 	checkStringLengthRange(localeKey,2, 16,LOCALE_KEY_OF_FORM_ACTION, messageList); 		
		
	}	 			
	
	public static final String  ACTION_KEY_OF_FORM_ACTION ="form_action.action_key";
	protected void checkActionKeyOfFormAction(PimUserContext userContext, String actionKey, List<Message> messageList)
	{
		
	 	checkStringLengthRange(actionKey,2, 24,ACTION_KEY_OF_FORM_ACTION, messageList); 		
		
	}	 			
	
	public static final String  LEVEL_OF_FORM_ACTION ="form_action.level";
	protected void checkLevelOfFormAction(PimUserContext userContext, String level, List<Message> messageList)
	{
		
	 	checkStringLengthRange(level,3, 28,LEVEL_OF_FORM_ACTION, messageList); 		
		
	}	 			
	
	public static final String  URL_OF_FORM_ACTION ="form_action.url";
	protected void checkUrlOfFormAction(PimUserContext userContext, String url, List<Message> messageList)
	{
		
	 	checkStringLengthRange(url,11, 168,URL_OF_FORM_ACTION, messageList); 		
		
	}	 			
	
	public static final String  FORM_OF_FORM_ACTION ="form_action.form";
	protected void checkFormIdOfFormAction(PimUserContext userContext, String formId, List<Message> messageList)
	{
		
	 	checkIdOfFormAction(userContext,formId, messageList); 		
		
	}	 			
	
	public static final String  VERSION_OF_FORM_ACTION ="form_action.version";
	protected void checkVersionOfFormAction(PimUserContext userContext, int version, List<Message> messageList)
	{
		
	 	checkIntegerRange(version,0, Integer.MAX_VALUE,VERSION_OF_FORM_ACTION, messageList); 		
		
	}	 			public Object checkAccess(BaseUserContext baseUserContext,String methodName, Object[] parameters) throws IllegalAccessException{
		if (!(baseUserContext instanceof PimUserContext)){
			super.checkAccess(baseUserContext, methodName, parameters);
			return accessOK();
		}
		PimUserContext userContext = (PimUserContext) baseUserContext;
		if (userContext.getCustomCheckManager() != null && this != userContext.getCustomCheckManager()){
			userContext.getCustomCheckManager().checkAccess(userContext, methodName, parameters);
			return accessOK();
		}
		return super.checkAccess(userContext, methodName, parameters);
	}
	
	protected void throwExceptionIfHasErrors(PimUserContext userContext, List<Message> messageList, Class<? extends PimException> exceptionClazz) throws Exception{
		//translate messages;
		if(messageList.isEmpty()){
			return;
		}
		
		
		for(Message message: messageList){
			String subject = message.getSubject();
			String template = userContext.getLocaleKey(subject);
			if(template==null){
				//not found, it is fine to use hard coded value
				userContext.log("Check Result "+message.getBody());
				continue;
			}
			MessageFormat mf = new MessageFormat(template);
			
			String labelKey = message.getFirstParam();
			String newLabel = userContext.getLocaleKey(labelKey);
			message.setFirstParam(newLabel);
			String newBody = mf.format(message.getParameters());
			message.setBody(newBody);
			userContext.log("Check Result "+message.getBody());
			
		}
		
		
		Class [] classes = {List.class};
		throw  exceptionClazz.getDeclaredConstructor(classes).newInstance(messageList);

	}
	*/

	protected void checkGender(String gender, int i, int j,String targetFieldName, List<Message> messageList) {
		
		
	}
	
	//for stub only
	protected void checkDateNow(Date likeTime, int i, Object now,
			String targetFieldName, PimException exception) {
		
		
	}


	protected Object now() {

		return null;
	}
	
	protected boolean isValidIdentifier(String value){
		return hasVisualChar(value);
		
	}
	
	protected boolean hasVisualChar(String value){
		if(value==null){
			return false;
		}
		if(value.isEmpty()){
			return false;
		}
		if(value.trim().isEmpty()){
			return false;
		}
		return true;
		
	}
	protected void checkBigDecimalRange(BigDecimal projectArea, double i, double j, String projectAreaOfProject,
			List<Message> messageList) {
		
	}
    
}











