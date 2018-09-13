import { TestBed, inject } from '@angular/core/testing';

import { GeneralViewService } from './general-view.service';

describe('GeneralViewService', () => {
  beforeEach(() => {
    TestBed.configureTestingModule({
      providers: [GeneralViewService]
    });
  });

  it('should be created', inject([GeneralViewService], (service: GeneralViewService) => {
    expect(service).toBeTruthy();
  }));
});
