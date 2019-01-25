import { get,postForm,PREFIX,joinParameters,joinPostParameters } from '../../axios/tools'


const view = (targetObjectId) => {
  return get({
    url: `${PREFIX}platformManager/view/${targetObjectId}/`,
  })
}



const load = (targetObjectId, parameters) => {
  const parametersExpr = joinParameters(parameters)
  return get({
    url: `${PREFIX}platformManager/loadPlatform/${targetObjectId}/${parametersExpr}/`,
  })
}







const addSite = (targetObjectId, parameters) => {
  const url = `${PREFIX}platformManager/addSite/platformId/name/introduction/tokensExpr/`
  const platformId = targetObjectId
  const requestParameters = { ...parameters, platformId, tokensExpr: 'none' }
  return postForm({ url,requestParameters})
}

const updateSite = (targetObjectId, parameters) => {
  const url = `${PREFIX}platformManager/updateSiteProperties/platformId/id/name/introduction/tokensExpr/`
  const platformId = targetObjectId
  const requestParameters = { ...parameters, platformId, tokensExpr: 'none' }
  return postForm({ url,requestParameters})
}

const removeSiteList = (targetObjectId, parameters) => {
  const url = `${PREFIX}platformManager/removeSiteList/platformId/siteIds/tokensExpr/`
  const requestParameters = { ...parameters, platformId: targetObjectId, tokensExpr: 'none' }
  return postForm({ url,requestParameters})
}



const addCatalog = (targetObjectId, parameters) => {
  const url = `${PREFIX}platformManager/addCatalog/platformId/name/sellerId/siteId/tokensExpr/`
  const platformId = targetObjectId
  const requestParameters = { ...parameters, platformId, tokensExpr: 'none' }
  return postForm({ url,requestParameters})
}

const updateCatalog = (targetObjectId, parameters) => {
  const url = `${PREFIX}platformManager/updateCatalogProperties/platformId/id/name/sellerId/tokensExpr/`
  const platformId = targetObjectId
  const requestParameters = { ...parameters, platformId, tokensExpr: 'none' }
  return postForm({ url,requestParameters})
}

const removeCatalogList = (targetObjectId, parameters) => {
  const url = `${PREFIX}platformManager/removeCatalogList/platformId/catalogIds/tokensExpr/`
  const requestParameters = { ...parameters, platformId: targetObjectId, tokensExpr: 'none' }
  return postForm({ url,requestParameters})
}



const addBrand = (targetObjectId, parameters) => {
  const url = `${PREFIX}platformManager/addBrand/platformId/brandName/logo/remark/tokensExpr/`
  const platformId = targetObjectId
  const requestParameters = { ...parameters, platformId, tokensExpr: 'none' }
  return postForm({ url,requestParameters})
}

const updateBrand = (targetObjectId, parameters) => {
  const url = `${PREFIX}platformManager/updateBrandProperties/platformId/id/brandName/logo/remark/tokensExpr/`
  const platformId = targetObjectId
  const requestParameters = { ...parameters, platformId, tokensExpr: 'none' }
  return postForm({ url,requestParameters})
}

const removeBrandList = (targetObjectId, parameters) => {
  const url = `${PREFIX}platformManager/removeBrandList/platformId/brandIds/tokensExpr/`
  const requestParameters = { ...parameters, platformId: targetObjectId, tokensExpr: 'none' }
  return postForm({ url,requestParameters})
}



const addProduct = (targetObjectId, parameters) => {
  const url = `${PREFIX}platformManager/addProduct/platformId/name/parentCategoryId/brandId/origin/catalogId/remark/tokensExpr/`
  const platformId = targetObjectId
  const requestParameters = { ...parameters, platformId, tokensExpr: 'none' }
  return postForm({ url,requestParameters})
}

const updateProduct = (targetObjectId, parameters) => {
  const url = `${PREFIX}platformManager/updateProductProperties/platformId/id/name/origin/remark/tokensExpr/`
  const platformId = targetObjectId
  const requestParameters = { ...parameters, platformId, tokensExpr: 'none' }
  return postForm({ url,requestParameters})
}

const removeProductList = (targetObjectId, parameters) => {
  const url = `${PREFIX}platformManager/removeProductList/platformId/productIds/tokensExpr/`
  const requestParameters = { ...parameters, platformId: targetObjectId, tokensExpr: 'none' }
  return postForm({ url,requestParameters})
}


const PlatformService = { view,
  load,
  addSite,
  addCatalog,
  addBrand,
  addProduct,
  updateSite,
  updateCatalog,
  updateBrand,
  updateProduct,
  removeSiteList,
  removeCatalogList,
  removeBrandList,
  removeProductList }
export default PlatformService

