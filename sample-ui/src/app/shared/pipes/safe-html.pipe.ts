import { DomSanitizer } from '@angular/platform-browser';
import { Pipe, PipeTransform } from '@angular/core';

/*
  innerHtml에서 보안 규칙으로 style, class attribute를 삭제되고 바인딩 되므로 
  해당 Pipe를 사용하여 bypass 함. 
  by SHCho
*/

@Pipe({
  name: 'safeHtml'
})
export class SafeHtmlPipe implements PipeTransform {

  constructor(private sanitized: DomSanitizer) {}
  transform(value) {
    return this.sanitized.bypassSecurityTrustHtml(value);
  }

}
