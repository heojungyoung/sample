import { BaseListData} from './shared/shared.model';

export interface SampleModel {
	id: number;
	name: string;
	cntrCode: string;
	population : string;
}

export interface SampleModelList extends BaseListData{
    data: SampleModel[];
}

