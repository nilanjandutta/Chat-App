import { Component, OnInit, OnDestroy } from '@angular/core';
import { NgForm } from '@angular/forms';
import { WebSocketService } from '../service/web-socket.service';
import { ChatMessageDto } from '../models/chatMessageDto';

@Component({
  selector: 'app-chat',
  templateUrl: './chat.component.html',
  styleUrls: ['./chat.component.css']
})
export class ChatComponent implements OnInit,OnDestroy {

  constructor(public webSocketservice:WebSocketService) { }

  ngOnInit(): void {
    this.webSocketservice.openWebSocket();
  }

  ngOnDestroy():void{
    this.webSocketservice.closedWebsocket();
  }
 sendMessage(sendForm:NgForm)
 {
   const chatMessageDto=new ChatMessageDto(sendForm.value.user,sendForm.value.message);
   this.webSocketservice.sendMessage(chatMessageDto);
   console.log(sendForm.value);
   sendForm.controls.message.reset();
 }
} 
