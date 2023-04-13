import { Pipe, PipeTransform } from '@angular/core';

@Pipe({
  name: 'truncateString',
  standalone: true
})
export class TruncateStringPipe implements PipeTransform {

  transform(value: string, limit: number): string {
    return value.length > limit ? value.substring(0, limit) + '...' : value;
  }

}
