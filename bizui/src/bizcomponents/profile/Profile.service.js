import { get,postForm,PREFIX,joinParameters,joinPostParameters } from '../../axios/tools'


const view = (targetObjectId) => {
  return get({
    url: `${PREFIX}profileManager/view/${targetObjectId}/`,
  })
}



const load = (targetObjectId, parameters) => {
  const parametersExpr = joinParameters(parameters)
  return get({
    url: `${PREFIX}profileManager/loadProfile/${targetObjectId}/${parametersExpr}/`,
  })
}



const requestCandidatePlatform = (ownerClass, id, filterKey, pageNo) => {
 
  const url = `${PREFIX}profileManager/requestCandidatePlatform/ownerClass/id/filterKey/pageNo/`
  const requestParameters = {id, ownerClass,filterKey, pageNo}
  return postForm({url,requestParameters})
}	

const transferToAnotherPlatform = (id, parameters) => {
  //const parametersExpr = joinParameters(parameters)
  const url = `${PREFIX}profileManager/transferToAnotherPlatform/id/anotherPlatformId/`
  const requestParameters = {id, ...parameters}
  return postForm({url,requestParameters})
}







const addBrandFilter = (targetObjectId, parameters) => {
  const url = `${PREFIX}profileManager/addBrandFilter/profileId/name/internalId/tokensExpr/`
  const profileId = targetObjectId
  const requestParameters = { ...parameters, profileId, tokensExpr: 'none' }
  return postForm({ url,requestParameters})
}

const updateBrandFilter = (targetObjectId, parameters) => {
  const url = `${PREFIX}profileManager/updateBrandFilterProperties/profileId/id/name/internalId/tokensExpr/`
  const profileId = targetObjectId
  const requestParameters = { ...parameters, profileId, tokensExpr: 'none' }
  return postForm({ url,requestParameters})
}

const removeBrandFilterList = (targetObjectId, parameters) => {
  const url = `${PREFIX}profileManager/removeBrandFilterList/profileId/brandFilterIds/tokensExpr/`
  const requestParameters = { ...parameters, profileId: targetObjectId, tokensExpr: 'none' }
  return postForm({ url,requestParameters})
}



const addPriceFilter = (targetObjectId, parameters) => {
  const url = `${PREFIX}profileManager/addPriceFilter/profileId/name/priceStart/priceEnd/tokensExpr/`
  const profileId = targetObjectId
  const requestParameters = { ...parameters, profileId, tokensExpr: 'none' }
  return postForm({ url,requestParameters})
}

const updatePriceFilter = (targetObjectId, parameters) => {
  const url = `${PREFIX}profileManager/updatePriceFilterProperties/profileId/id/name/priceStart/priceEnd/tokensExpr/`
  const profileId = targetObjectId
  const requestParameters = { ...parameters, profileId, tokensExpr: 'none' }
  return postForm({ url,requestParameters})
}

const removePriceFilterList = (targetObjectId, parameters) => {
  const url = `${PREFIX}profileManager/removePriceFilterList/profileId/priceFilterIds/tokensExpr/`
  const requestParameters = { ...parameters, profileId: targetObjectId, tokensExpr: 'none' }
  return postForm({ url,requestParameters})
}



const addCategoryFilter = (targetObjectId, parameters) => {
  const url = `${PREFIX}profileManager/addCategoryFilter/profileId/name/internalId/tokensExpr/`
  const profileId = targetObjectId
  const requestParameters = { ...parameters, profileId, tokensExpr: 'none' }
  return postForm({ url,requestParameters})
}

const updateCategoryFilter = (targetObjectId, parameters) => {
  const url = `${PREFIX}profileManager/updateCategoryFilterProperties/profileId/id/name/internalId/tokensExpr/`
  const profileId = targetObjectId
  const requestParameters = { ...parameters, profileId, tokensExpr: 'none' }
  return postForm({ url,requestParameters})
}

const removeCategoryFilterList = (targetObjectId, parameters) => {
  const url = `${PREFIX}profileManager/removeCategoryFilterList/profileId/categoryFilterIds/tokensExpr/`
  const requestParameters = { ...parameters, profileId: targetObjectId, tokensExpr: 'none' }
  return postForm({ url,requestParameters})
}



const addNewProduct = (targetObjectId, parameters) => {
  const url = `${PREFIX}profileManager/addNewProduct/profileId/name/parentCategoryId/brandId/productCoverImage/origin/catalogId/remark/platformId/tokensExpr/`
  const profileId = targetObjectId
  const requestParameters = { ...parameters, profileId, tokensExpr: 'none' }
  return postForm({ url,requestParameters})
}

const updateNewProduct = (targetObjectId, parameters) => {
  const url = `${PREFIX}profileManager/updateNewProductProperties/profileId/id/name/productCoverImage/origin/remark/tokensExpr/`
  const profileId = targetObjectId
  const requestParameters = { ...parameters, profileId, tokensExpr: 'none' }
  return postForm({ url,requestParameters})
}

const removeNewProductList = (targetObjectId, parameters) => {
  const url = `${PREFIX}profileManager/removeNewProductList/profileId/newProductIds/tokensExpr/`
  const requestParameters = { ...parameters, profileId: targetObjectId, tokensExpr: 'none' }
  return postForm({ url,requestParameters})
}



const addEditorPickProduct = (targetObjectId, parameters) => {
  const url = `${PREFIX}profileManager/addEditorPickProduct/profileId/name/parentCategoryId/brandId/productCoverImage/origin/catalogId/remark/platformId/tokensExpr/`
  const profileId = targetObjectId
  const requestParameters = { ...parameters, profileId, tokensExpr: 'none' }
  return postForm({ url,requestParameters})
}

const updateEditorPickProduct = (targetObjectId, parameters) => {
  const url = `${PREFIX}profileManager/updateEditorPickProductProperties/profileId/id/name/productCoverImage/origin/remark/tokensExpr/`
  const profileId = targetObjectId
  const requestParameters = { ...parameters, profileId, tokensExpr: 'none' }
  return postForm({ url,requestParameters})
}

const removeEditorPickProductList = (targetObjectId, parameters) => {
  const url = `${PREFIX}profileManager/removeEditorPickProductList/profileId/editorPickProductIds/tokensExpr/`
  const requestParameters = { ...parameters, profileId: targetObjectId, tokensExpr: 'none' }
  return postForm({ url,requestParameters})
}



const addTopRatedProduct = (targetObjectId, parameters) => {
  const url = `${PREFIX}profileManager/addTopRatedProduct/profileId/name/parentCategoryId/brandId/productCoverImage/origin/catalogId/remark/platformId/tokensExpr/`
  const profileId = targetObjectId
  const requestParameters = { ...parameters, profileId, tokensExpr: 'none' }
  return postForm({ url,requestParameters})
}

const updateTopRatedProduct = (targetObjectId, parameters) => {
  const url = `${PREFIX}profileManager/updateTopRatedProductProperties/profileId/id/name/productCoverImage/origin/remark/tokensExpr/`
  const profileId = targetObjectId
  const requestParameters = { ...parameters, profileId, tokensExpr: 'none' }
  return postForm({ url,requestParameters})
}

const removeTopRatedProductList = (targetObjectId, parameters) => {
  const url = `${PREFIX}profileManager/removeTopRatedProductList/profileId/topRatedProductIds/tokensExpr/`
  const requestParameters = { ...parameters, profileId: targetObjectId, tokensExpr: 'none' }
  return postForm({ url,requestParameters})
}



const addRecommandProduct = (targetObjectId, parameters) => {
  const url = `${PREFIX}profileManager/addRecommandProduct/profileId/name/parentCategoryId/brandId/productCoverImage/origin/catalogId/remark/platformId/tokensExpr/`
  const profileId = targetObjectId
  const requestParameters = { ...parameters, profileId, tokensExpr: 'none' }
  return postForm({ url,requestParameters})
}

const updateRecommandProduct = (targetObjectId, parameters) => {
  const url = `${PREFIX}profileManager/updateRecommandProductProperties/profileId/id/name/productCoverImage/origin/remark/tokensExpr/`
  const profileId = targetObjectId
  const requestParameters = { ...parameters, profileId, tokensExpr: 'none' }
  return postForm({ url,requestParameters})
}

const removeRecommandProductList = (targetObjectId, parameters) => {
  const url = `${PREFIX}profileManager/removeRecommandProductList/profileId/recommandProductIds/tokensExpr/`
  const requestParameters = { ...parameters, profileId: targetObjectId, tokensExpr: 'none' }
  return postForm({ url,requestParameters})
}


const ProfileService = { view,
  load,
  addBrandFilter,
  addPriceFilter,
  addCategoryFilter,
  addNewProduct,
  addEditorPickProduct,
  addTopRatedProduct,
  addRecommandProduct,
  updateBrandFilter,
  updatePriceFilter,
  updateCategoryFilter,
  updateNewProduct,
  updateEditorPickProduct,
  updateTopRatedProduct,
  updateRecommandProduct,
  removeBrandFilterList,
  removePriceFilterList,
  removeCategoryFilterList,
  removeNewProductList,
  removeEditorPickProductList,
  removeTopRatedProductList,
  removeRecommandProductList,
  requestCandidatePlatform,
  transferToAnotherPlatform }
export default ProfileService

