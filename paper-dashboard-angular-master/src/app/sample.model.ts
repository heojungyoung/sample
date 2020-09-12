import { BaseListData} from './shared/shared.model';

export interface SampleModel {
    id : string,
	name : string;
	cntrcode: string;
	population : string;
}

export interface SampleModelList extends BaseListData{
    data: SampleModel[];
}

export interface hintModel {
	typeKey: string;
	typeVal: string;
}


