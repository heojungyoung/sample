import { Component } from '@angular/core';
import { SampleHttpService } from './sample-http.service';
import { OnInit } from '@angular/core';
import { SampleModel } from './sample.model';
import * as _ from 'lodash'; 

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent implements OnInit {
  title = 'sample-ui';
  SampleList: SampleModel[] = [];
  plcyId = '3';	

  constructor(
    public sampleHttpService : SampleHttpService  
  ) { }

  ngOnInit() {
   // this.sampleHttpService.getSampleList(this.plcyId).subscribe( data => {
		
	//	this.SampleList = data.data;
	 //   console.log(this.SampleList);  
  //  });

    var data = [{
      "typeId": "5435",
      "hintKeyTypeCd": "string",
      "typekey": "strTest",
      "typeVal" : "str1",
      "prntsTypeId" : null,
      "hintId" : null,
      "saveVal" : null,
      "typeLvlRank" : 1,
      "mndtYn" : "N"
    }, {
      "typeId": "5435",
      "hintKeyTypeCd": "string",
      "typekey": "strTest",
      "typeVal" : "str2",
      "prntsTypeId" : null,
      "hintId" : 32,
      "saveVal" : null,
      "typeLvlRank" : 1,
      "mndtYn" : "N"
    }, {
      "typeId": "72",
      "hintKeyTypeCd": "int",
      "typekey": "intTest",
      "typeVal" : "int1",
      "prntsTypeId" : null,
      "hintId" : null,
      "saveVal" : null,
      "typeLvlRank" : 1,
      "mndtYn" : "N"
    }, {
      "typeId": "72",
      "hintKeyTypeCd": "int",
      "typekey": "intTest",
      "typeVal" : "int2",
      "prntsTypeId" : null,
      "hintId" : null,
      "saveVal" : null,
      "typeLvlRank" : 1,
      "mndtYn" : "N"
    },{
      "typeId": "5435",
      "hintKeyTypeCd": "string",
      "typekey": "strTest",
      "typeVal" : "str7",
      "prntsTypeId" : null,
      "hintId" : null,
      "saveVal" : null,
      "typeLvlRank" : 1,
      "mndtYn" : "N"
    }];
           
    var grouped = _.mapValues(_.groupBy(data, 'typeId'),
    list => list.map(item => _.omit(item, 'typeId'))
    );

    //console.log(grouped);
    var list = new Array();
    let abc = data.map(function (o) {return o.typeId;});
    const foo = new Set(abc);
    foo.forEach(element => { 
     
      let obj = {
          typeId: null,
          hintKeyTypeCd: null,
          typeKey: null,
          prntsTypeId : null,
          hintId : null ,
          saveVal : null,
          typeValId : null,
          typeLvlRank : null,
          mndtYn : null,
          valList :[],
          selectedVal : null
      };

      data.forEach(item => { 
        if(item.typeId == element ){     
          obj.typeId = item.typeId;
          obj.typeKey = item.typekey;
          obj.hintKeyTypeCd = item.hintKeyTypeCd;
          obj.prntsTypeId = item.prntsTypeId;
          obj.typeLvlRank = item.typeLvlRank;
          obj.mndtYn = item.mndtYn;
          if (item.hintId != null )
						{
              obj.hintId = item.hintId;
              obj.saveVal = item.saveVal;
            }
          let oo = {
            typeVal : item.typeVal
          }
          obj.valList.push(oo);
         
        }else{
          return false;
        }
      });
      list.push(obj);
    });
    console.log(list);  
  }

}
