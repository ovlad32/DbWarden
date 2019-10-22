<template>
    <aside class="sm-aside">
        <div class="user-head">
            <img src="./../assets/profile.jpg">
            <div class="user-name">
                <h5>User name</h5>
                <span class="email-address">user@vmail.com</span>
            </div>
        </div>
        <ul class="inbox-nav">
            <li :class="{ active: activeView=='app-inbox'} ">
                <a href="#" @click.prevent="navigate('app-inbox','Inbox')">
                    <i class="fa fa-inbox"></i>Inbox
                    <span class="label label-danger pull-right">{{inboxMessages.length}}</span>
                </a>
            </li>
            <li :class="{ active: activeView=='app-sent'} ">
                <a href="#" @click.prevent="navigate('app-sent','Sent')">
                    <i class="fa fa-envelope"></i>Sent
                    <span class="label label-danger pull-right">{{sentMessages.length}}</span>
                </a>
            </li>
            <li :class="{ active: activeView=='app-important'} ">
                <a href="#" @click.prevent="navigate('app-important','Important')">
                    <i class="fa fa-bookmark-o"></i>Important
                    <span class="label label-warning pull-right">{{importantMessages.length}}</span>
                </a>
            </li>
            <li :class="{ active: activeView=='app-trash'} ">
                <a href="#" @click.prevent="navigate('app-trash','Trash')">
                    <i class="fa fa-bookmark-o"></i>Trash
                    <span class="label label-danger pull-right">{{deletedMessages.length}}</span>
                </a>
            </li>
        </ul>
    </aside>
</template>
<script>
    import {eventBus} from "../main";

    export default {
        props: {
            messages: {
                type:Array,
                required:true
            }
        },
        created() {
            eventBus.$on('changeView',(v)=>{
                this.activeView = v.tag
            })
        },
        data() {
            return {
                activeView:'app-inbox'
            }
        },
        methods: {
            navigate(newView, title) {
                eventBus.$emit('changeView',{
                    tag:newView,
                    title:title
                })
            }
        },
        computed: {
            inboxMessages() {
                return this.messages.filter((m)=>{
                    return (m.type === 'incoming' && !m.isDeleted);
                })
            },
            sentMessages() {
                return this.messages.filter((m)=>{
                    return (m.type === 'outgoing' && !m.isDeleted);
                })
            },
            importantMessages() {
                return this.messages.filter((m)=>{
                    return (m.type === 'incoming' && m.isImportant === true && !m.isDeleted);
                })
            },
            deletedMessages() {
                return this.messages.filter((m)=>{
                    return (m.isDeleted === true);
                })
            }
        }
    }
</script>