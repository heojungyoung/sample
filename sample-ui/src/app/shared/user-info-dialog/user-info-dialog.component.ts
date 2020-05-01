import { UserModel } from './../../authority/user/user.model';
import { HttpClient } from '@angular/common/http';
import { UserHttpService } from './../../authority/user/user-http.service';
import { Component, OnInit, Inject } from '@angular/core';
import { MatDialogRef, MAT_DIALOG_DATA } from '@angular/material';

@Component({
  selector: 'app-user-info-dialog',
  templateUrl: './user-info-dialog.component.html',
  styleUrls: ['./user-info-dialog.component.css']
})
export class UserInfoDialogComponent implements OnInit {

  guid: string;
  UserHttpService: UserHttpService | null;
  userInfoData = {} as UserModel;
  noResult = false;
  isResult = false;
  constructor(
    public dialogRef: MatDialogRef<UserInfoDialogComponent>,
    @Inject(MAT_DIALOG_DATA) public data: string,
    private _httpClient: HttpClient) {
      this.guid = data;
      this.UserHttpService = new UserHttpService(this._httpClient);
      this.UserHttpService.getUserInfoPop(this.guid).subscribe(response => {
      if (response.data !== undefined) {
        this.userInfoData = response.data;
        this.noResult = false;
      } else {
        this.noResult = true;
      }
      this.isResult = true;
    });
  }

  ngOnInit() {

  }

  onClose() {
    this.dialogRef.close();
  }

}
