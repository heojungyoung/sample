import { BaseListData} from './shared/shared.model';

export interface SampleModel {
  custState: string;
  custCity: string;
  custPhoneNumber: string;
  custZipCode: string;
  customerid : string;
    id : string,
	name : string;
	cntrcode: string;
	population : string;
}

export interface SampleModelList extends BaseListData{
    data: SampleModel[];
}

export interface svcModel {
	vaSvcId: number;
	vaCntrId : number;
	sprtYear: string;
	vaTypeCd :string;
	vaSvcNm : string;
	regPgmId : string;
	mdfPgmId : string;
	regrId : string;
	regDt :string;
	mdfrId : string;
	mdfDt : string;
	cntrCd :string;
}

export interface svcModelList extends BaseListData{
    data: svcModel[];
}
