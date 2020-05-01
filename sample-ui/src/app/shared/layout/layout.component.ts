import { ActivatedRoute, RouterStateSnapshot, ActivatedRouteSnapshot, Router } from '@angular/router';
import { MatDialog } from '@angular/material';
import { Component, OnInit, ChangeDetectorRef, OnDestroy, AfterViewInit } from '@angular/core';
import { MediaMatcher } from '@angular/cdk/layout';
import { TimerObservable } from 'rxjs/observable/TimerObservable';
import { Subscription } from 'rxjs';

import { environment } from './../../../environments/environment';
import { AuthenticationService } from './../../core/services/auth.service';
import { SpinnerService } from '../../core/services/spinner.service';
import { AuthGuard } from 'src/app/core/guards/auth.guard';
import { UserInfoDialogComponent } from '../user-info-dialog/user-info-dialog.component';

@Component({
    selector: 'app-layout',
    templateUrl: './layout.component.html',
    styleUrls: ['./layout.component.css']
})
export class LayoutComponent implements OnInit, OnDestroy, AfterViewInit {

    private _mobileQueryListener: () => void;
    mobileQuery: MediaQueryList;
    showSpinner: boolean;
    userName: string;
    isAdmin: boolean;
    navMenuList: string[] = [];
    navMenuTitle = '';

    // sample MenuAuthData
    menuAuthList: MenuAuthModel[] = [];

    private autoLogoutSubscription: Subscription;

    constructor(private changeDetectorRef: ChangeDetectorRef,
        private media: MediaMatcher,
        public spinnerService: SpinnerService,
        private authService: AuthenticationService,
        private authGuard: AuthGuard,
        private _route: ActivatedRoute,
        public _router: Router,
        private dialog: MatDialog) {

        this.mobileQuery = this.media.matchMedia('(max-width: 1000px)');
        this._mobileQueryListener = () => changeDetectorRef.detectChanges();
        // tslint:disable-next-line: deprecation
        this.mobileQuery.addListener(this._mobileQueryListener);
        this.menuAuthList = this.authService.getCurrentMenuAuth();
    }

    ngOnInit(): void {

        this.caculateMenu();
        this.authService.login();
        const user  = this.authService.getCurrentUser();
        //this.authService.setUserAuthData(this.menuAuthList);
        console.log('layout-Init():', user);
       /*  this.isAdmin = user.isAdmin;
        this.userName = user.fullName;
       */
        // Auto log-out subscription
       /*  const timer = TimerObservable.create(2000, 5000);
        this.autoLogoutSubscription = timer.subscribe(t => {
            this.authGuard.canActivate();
        }); */
    }

    ngOnDestroy(): void {
        // tslint:disable-next-line: deprecation
        this.mobileQuery.removeListener(this._mobileQueryListener);
        
       // this.autoLogoutSubscription.unsubscribe();
    }

    ngAfterViewInit(): void {
        this.changeDetectorRef.detectChanges();
        
    }

    hasChild(row: MenuAuthModel): boolean {

        return !!row.child && row.child.length > 0;
    }

    caculateMenu() {
        const currUrl = this.removeHash(this._router.url.split('/').slice(1));
        const navTitleList: string[] = [];
        
        if ( currUrl.includes('detail')
            || currUrl.includes('registration')) {
                let idx = currUrl.indexOf('detail');
                if ( idx !== -1 ) {
                    this.navMenuList = this.firstUpper(currUrl.slice(0, idx + 1));
                    this.navMenuTitle = this.navMenuList.slice(0, idx).join(' - ');
                } else {
                    idx = currUrl.indexOf('registration');
                    this.navMenuList = this.firstUpper(currUrl.slice(0, idx + 1));
                    this.navMenuTitle = this.navMenuList.slice(0, idx).join(' - ');
                }
                
            } else {
                this.navMenuList = this.firstUpper(currUrl);
                this.navMenuTitle = this.navMenuList.slice(0, 2).join(' - ');
            }

    }

    removeHash( tmp: string[]): string[] {
        tmp.forEach( (x, i) => {
            const idx = x.indexOf('#');
            if ( idx !== -1 ) {
                tmp[i] = x.slice(0, idx);
            }
        });
        return tmp;
    }

    firstUpper( tmp: string[]): string[] {
        tmp.forEach( (x, i) => {
            if ( x.includes('-')) {
                let tt = x.split('-');
                tt.forEach( (t, x) => {
                    tt[x] = t.charAt(0).toUpperCase() + t.slice(1);
                });
                tmp[i] = tt.join(' ');
            } else {
                tmp[i] = x.charAt(0).toUpperCase() + x.slice(1);
            }
        });
        return tmp;
    }
}

export interface MenuAuthModel {
    menuCd: string;
    menuCdNm: string;
    authDivCd: string;
    path: string;
    child?: MenuAuthModel[];
}