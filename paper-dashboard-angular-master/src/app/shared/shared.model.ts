export interface BaseResponse {
    stat: string;
}

export interface BaseListData {
    total?: number;
    page?: number;
    perPage?: number;
}

export interface ServiceFilterResponse extends BaseResponse {
    data: FilterModel[];
}

export interface CommonCodeList extends BaseListData {
    list: CommonCodeModel[];
}

export interface CommonCodeListResponse extends BaseResponse {
    data: CommonCodeList;
}

export interface FilterModel {
    svcDivCd: string;
    svcDivNm: string;
}

export interface CommonCodeModel {
    comnCd: string;
    repCdNm: string;
}

export interface CommonCodeMenuModel {
    comnCd: string;
    repCdNm: string;
    authDivCd?: string;
    child?: CommonCodeMenuModel[];
}

export interface CommonCodeMenuList extends BaseListData {
    list: CommonCodeMenuModel[];
}

export interface CommonCodeMenuListResponse extends BaseResponse {
    data: CommonCodeMenuList;
}


