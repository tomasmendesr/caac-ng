import { TestBed, inject } from '@angular/core/testing';

import { VencimientoService } from './vencimiento.service';

describe('VencimientoService', () => {
  beforeEach(() => {
    TestBed.configureTestingModule({
      providers: [VencimientoService]
    });
  });

  it('should be created', inject([VencimientoService], (service: VencimientoService) => {
    expect(service).toBeTruthy();
  }));
});
