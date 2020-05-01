import { Component } from '@angular/core';
import { SampleHttpService } from './sample-http.service';
import { OnInit } from '@angular/core';
import { SampleModel } from './sample.model';


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
    	this.sampleHttpService.getSampleList(this.plcyId).subscribe( data => {
		console.log(data);      	
		this.SampleList = data.data;
	    console.log(this.SampleList);  
    });
  }

}
