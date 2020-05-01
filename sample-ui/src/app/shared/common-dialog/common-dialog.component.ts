import { MatDialog, MatDialogRef, MAT_DIALOG_DATA } from '@angular/material';
import { Component, OnInit, Inject, ViewEncapsulation } from '@angular/core';

@Component({
  selector: 'app-common-dialog',
  templateUrl: './common-dialog.component.html',
  styleUrls: ['./common-dialog.component.css'],
  encapsulation: ViewEncapsulation.None
})
export class CommonDialogComponent implements OnInit {

  title: string;
  content: string;
  type: CommonDialogType;

  // tslint:disable-next-line: no-use-before-declare
  dialogType = CommonDialogType;

  constructor(
    public dialogRef: MatDialogRef<CommonDialogComponent>,
    @Inject(MAT_DIALOG_DATA) public data: CommonDialogModel
  ) {
    this.type = data.type;
    this.title = data.type.toString();
    this.content = this.data.content;
    console.log(this.content);
  }

  ngOnInit() {
    
  }

  onConfirm(): void {
    this.dialogRef.close(true);
  }

  onDismiss(): void {
    this.dialogRef.close(false);
  }

  onClose(): void {
    this.dialogRef.close();
  }

}


export class CommonDialogModel {
  constructor(
    public type: CommonDialogType,
    public content: string
  ) {}
}

export enum CommonDialogType {
  Alert = 'Alert',
  Warning = 'Warning',
  Info = 'Information',
  Confirm = 'Confirm'
}
