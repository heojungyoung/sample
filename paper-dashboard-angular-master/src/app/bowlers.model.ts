import { BaseListData} from './shared/shared.model';

export interface bowlers {
	bowlerID: number;
	bowlerLastName : string;
	bowlerFirstName: string;
	bowlerMiddleInit :string;
	bowlerAddress : string;
	bowlerCity : string;
	bowlerState : string;
	bowlerZip : string;
	bowlerPhoneNumber :string;
	teamID : number;
}

export interface bowlersList extends BaseListData{
    data: bowlers[];
}
