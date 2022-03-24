import { StorageService } from './../../services/storage.service';
import { Router } from '@angular/router';
import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-header',
  templateUrl: './header.component.html',
  styleUrls: ['./header.component.scss']
})
export class HeaderComponent implements OnInit {

  constructor(private router: Router,
    private storageService: StorageService) { }

  ngOnInit(): void {
  }
  logout(){
    this.storageService.delete('AuthToken');
    this.router.navigate(['login']);
  }


}
