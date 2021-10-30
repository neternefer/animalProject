import { TestBed } from '@angular/core/testing';

import { AdopterServiceService } from './adopter-service.service';

describe('AdopterServiceService', () => {
  let service: AdopterServiceService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(AdopterServiceService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
