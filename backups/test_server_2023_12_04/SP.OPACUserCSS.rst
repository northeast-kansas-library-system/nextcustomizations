XX.OPACUserCSS.txt

----------

Preference name: OPACUserCSS

Type: Systempreference

Options: 

----------

Preference value: 



@media screen and (max-width:768px){

  #holdingst thead, #holdingst tfoot {
    display: none;
  }

  #holdingst {
    background: none !important;
    border: none !important;
  }

  #holdingst tr {
    display: inline-block;
    padding: 1rem 0.5rem 1rem 0.5rem;
    margin: 1.5rem;
    border: 1px solid grey;
    border-radius 10px;
    box-shadow: 0 0 10px;
    width: 90%
  }

  #holdingst td {
    display: block;
  }

}

#patronregistration-modal {display: none;}



#patron-userid, #patron-password, #patron-cardnumber {background-color: yellow;}

#opac-main .carrouselFrame {display: ;}

#loginModal .modal-body {overflow: hidden;}

#loginModal {max-height: 85%; overflow-y: auto;}

#submit-pay {border: 1px solid black !important;}

/*=======================================================LATE TO THE PARTY=============================================================== =*/
/*==========This hides the category selector===============*/
#masthead_search {
display: none !important;
}


/*===============Editing the Go button==========*/
#searchsubmit {

  padding-left: 1em !important;
}
#select_library {
  width: 7.25em !important;
}

/*============This hides powered buy koha, showed up after production move========*/
#koha_url > p:nth-child(1) {
display: none;
}
/*This Display:None might do bad things, I hid it because it was showing up on the front page, who know what else it is hiding*/
.span3 {
display:none;
}
/*=============General Styles============*/
html {
    height: 100%;
}

body {
    background: #fff;

}

h1 {
    font-family: 'Roboto', sans-serif;
    color: #0056B8;
}

a {
    color: #0056B8 !important;
    outline: none !important;
    text-decoration: none !important;
}

a:hover {
  color: #1F9BDE !important;
  text-decoration: none !important;
}
a:visited {
  color: #1F9BDE !important;
  text-decoration: none !important;
}
ul {
    list-style: none;
}

#wrap {
    width: 100%;
    min-height: 0% !important;
    padding: 0;
}
.navbar {
  background-color: #57585C;
  margin-left: -40px;
  margin-right: -40px;
}

a.navbar-brand, #logo{
  background-image: url("/images/6a98a0f924100eb7fdaba6d55045fe48_home.png") !important;
  background-repeat: no-repeat;
  background-size: 15px;
  background-position: center;
}

a.title {
  color: #0056B8 !important;
}
.cartlabel, .caret {
  display:none
}

#listsmenu {
  display: none;
}
#basketcount {
  display: none;
}

.dropdown_open {
  display: none;
}



/*Standardize Thumbnails*/
img.coverimages {
  width: 200px;
}
/*Buttons*/

.btn:hover, .btn:focus, .btn:active, .btn.active, .btn.disabled, .btn[disabled] {
  color: #3A3A3D;
  text-decoration: none;
  border: 1px solid #57585C;
}

#subscribetext {
    margin-left: 25px;
}

#subscribebtn {
    float: right;
    margin-top: 10px;
}

.btn.btn-default.more-less-options {
    color: #3A3A3D;
}

/*hold button*/

.btn.btn-link.js-show {
    color: #3A3A3D;
    font-family: 'Roboto', sans-serif;
    text-transform: uppercase;
    display: inline-block;
    *display: inline;
    *zoom: 1;
    margin-bottom: 0;
    font-size: 14px;
    line-height: 20px;
    text-align: center;
    vertical-align: middle;
    cursor: pointer;
    text-shadow: none;
    *background-color: #E3E3E3;
    *margin-left: .3em;
    cursor: pointer;
    display: inline-block;
    font-size: 16px;
    font-weight: 300;
    line-height: normal;
    padding: 12px 32px;
    position: relative;
    border-radius: 0px;
    margin-left: 5px;
    text-decoration: none;
}

/*icons*/

.icon-pause::before {
    content: "\f04b";
    font-family: FontAwesome;
    color: #ffffff;
    content: "\f04c";
    font-style: normal;
}

.icon-play::before {
    font-family: FontAwesome;
    content: "\f04b";
    font-style: normal;
}

.btn.btn-link.js-show:hover {
  color: #3A3A3D;
  text-decoration: none;
  border: 1px solid #57585C;
}


/*Input*/

textarea, input[type="text"], input[type="password"], input[type="datetime"], input[type="datetime-local"], input[type="date"], input[type="month"], input[type="time"], input[type="week"], input[type="number"], input[type="email"], input[type="url"], input[type="search"], input[type="tel"], input[type="color"], .uneditable-input {
    background-color: #ffffff;
    border-top: 2px solid #D7D7D6;
    border-bottom: 2px solid #D7D7D6;
    -webkit-box-shadow: none;
    -moz-box-shadow: none;
    box-shadow: inset none;
    -webkit-transition: none;
    -moz-transition: none;
    -o-transition: border linear .2s, box-shadow linear .2s;
    transition: border linear .2s, box-shadow linear .2s;
    border-radius: 0 !important;
    height: 100%;
    padding: 10px;
    margin: 0px;
}


input.span6 {
    color:#000000;
    height: 31%;
}

#toolbar select, #opac-main-search select, .toolbar select {
    font-family: 'Roboto', sans-serif;
    text-indent: 0.01px;
    width: 100%;
    font-size: 14px;
    margin-bottom: 24px;
    padding-right: -10px;
    background: #fff;
    border-radius: 0px;
    border: 1px solid #E5E5E4;
    outline: 0;
    color: #7B7d80 !important;
    height: 43px;
    appearance: none;
    background-color: #fff !important;
    outline: none;
    color: rgb(0, 0, 0);
    -webkit-appearance: none;
    margin-bottom: 0;
}

.table .sorting_asc {
    padding-right: 19px;
    background: url(../images/asc.gif) right center no-repeat #0056B8;
    color: #ffffff;
    font-family: 'Roboto', sans-serif;
    font-size: 16px;
    font-weight:300;
}

.table .sorting {
    padding-right: 19px;
    background: url(../images/ascdesc.gif) right center no-repeat #0056B8;
    color:#ffffff;
    font-family: 'Roboto', sans-serif;
    font-size: 16px;
    font-weight:300;
}

/*button small, for saving titles*/

.save_text {
    font-family: 'Roboto', sans-serif;
    text-transform: uppercase;
    text-shadow: none;
    font-size: 14px;
    color: #0056B8;
    text-decoration: none;
    font-weight:300;
}

#login4tags {
    background-image: none;
    font-family: 'Roboto', sans-serif;
    font-weight:300;
}

#placehold {
    width:90%;
}

/* 4.24.2023 "Confirm Hold Button"*/

input.btn:nth-child(6) {
font-size: 2em;
color: #fff !important;
background-color: #0056B8 !important;
border-radius: 25px !important;
margin-bottom: 2em;
}
/*input.btn.btn-small[type="submit"] {
    *padding-top: 20px;
    *padding-bottom: 3px;
    width: 100% !important;
    margin-top: 20px;
}
*/
input.btn:nth-child(5){
font-size: 2em;
color: #fff !important;
background-color: #0056B8 !important;
border-radius: 25px !important;
margin-bottom: 2em;
}
input.hold, input.hold.disabled {
    border: 0;
    color: #ffffff !important;
    font-family: 'Roboto', sans-serif;
    font-weight:400;
    text-transform: none;
    vertical-align: middle;
    margin-top: -10px !important;
    padding: 11px !important;
    background-image: none;
    background-color: #0056B8;
}

input.hold:hover, input.hold.disabled:hover {
   background-color: #1F9BDE !important;
   color: white;
}



.ItemSummary::before {
  content: "\a ";
  white-space: pre;
}

.unavailable::before {
    content: "\a \a Unavailable items: \a ";
    font-weight: bolder;
    white-space: pre;
}

.results_summary.availability {
  border: 1px solid lightgray;
  margin-right: 1.5%;
  max-height: 94px;
  overflow-y: scroll;
  padding: 5px;
  position: relative;
  width: 97%;
}


#addto, .checkall, .btn-small, .clearall {
    margin-bottom: 10px;
}

/*accessibility focus*/

/*a:active, a:focus {
    border: 0px solid orange !important;*/
}

#search-facets button:focus, author_statement:focus {
    border: 1px solid #0056B8 !important;
}



#usermessaging label {
    font-weight: bold;
}

#usermessaging li {
	list-style: none;
}


/*======================================================HEADER=========================================================================*/
/*Sticky Hoodoo*/
#opac-main-search {
    -webkit-transition: all 10s;
    -moz-transition: all 10s;
    transition: all 10s;
}
/*
.fixed {
    position: fixed;
    top:37px;
    left:0;
    right:0;
    margin: 0 auto;
    width: 95%;
    background-color:#ffffff;
    -webkit-transition: all 3s;
    -moz-transition: all 3s;
    transition: all 3s;
    z-index:99999;
}

.fixed-nav {
    position: fixed;
    top: 0px;
    left: 0px;
    right: 0px;
    margin: 0 auto;
    width: 95%;
    z-index: 9999;
    -webkit-transition: 0.3s;
    -mob-transition: 0.3s;
    transition: 0.3s;
}*/

/*Navbar*/
header nav {
    width: 100%;
    font-size: 1em;
}


.navbar-inverse .navbar-inner {
    background-color: #57585C;
    background-image: linear-gradient(to bottom, #57585C, #57585C);
    background-repeat: repeat-x;
    border-color: transparent;
}

.navbar-inverse .divider-vertical {
    border-left-color: #57585C;
    border-right-color: #57585C;
}

.navbar-inverse .brand, .navbar-inverse .nav > li > a, #members a, #members p, #logout  {
    color: #ffffff;
    text-shadow: none;
    font-weight: 300 !important;
    font-family: 'Roboto', sans-serif;
}



.fa.fa-icon-white {
  color: #fff;
}
#opacheader {
    background-color: transparent;
}
ul.nav {
  font-size: 18px;
}
.search_history > a:nth-child(1) {
  color: #fff !important;

}
#members .search_history a.logout {
	font-size: 100%;
  font-weight: 300;
}
/*.search_history > a:nth-child(1)::before, .search_history > a:nth-child(1)::after {
  content: "  |  ";

}


span.divider-vertical {
  display: none;

}*/

.search_history {

 display: none;
}
#members a.logout {
  color: #fff !important;
  font-size: 18px
}
ul.nav:nth-child(1) > li:nth-child(3) > p:nth-child(1) > a:nth-child(1){
  color: #fff !important;
}

/*DropDown Login       19.11 upgrade        */

#loggedinuser-menu {
  background-color: #57585C !important;
  min-width: 240px;

}
.open > .dropdown-menu {
	background-color: #57585C !important;
  box-shadow: 0px;
}

.loggedinusername {
	color: #fff !important;
	font-size: 18px;
}
/*=====================================================HEADER=END=====================================================================*/

/*=====================================================CONTENT=AREA===================================================================*/
/*login */
#login {
  display: none;
}

#login .btn {
    font-family: 'Roboto', sans-serif;
    display: inline-block;
    *display: inline;
    *zoom: 1;
    padding: 4px 12px;
    margin-bottom: 0;
    font-size: 16px;
    text-align: center;
    vertical-align: middle;
    cursor: pointer;
    color: #57585C;
    text-shadow: none;
    background-color: #e3e3e3;
    *margin-left: .3em;
    cursor: pointer;
    display: inline-block;
    font-weight: 300;
    line-height: normal;
    padding: 10px 88px;
    position: relative;
    border-radius: 0px;
    margin-left: 10px;
}

#login {
    background-color: #DCDFE0;
    border-radius: 2px;
    border-top: 8px solid #B4B7B8;
    width: 273px;
    margin: 0 auto;
}

#login legend {
    font-family: 'Roboto', sans-serif;
    color: #000;
    font-size: 16px;
    font-weight: 300;
    border: none;
    text-align: center;
}

#login label {
    font-family: 'Roboto', sans-serif;
    color: #000;
    font-size: 16px;
    font-weight: 300;
    border: none;
    padding: 10px;
}

#userid, #password {
    margin-left: 10px;
}

#login form {
    margin: 0 0 20px;
    width: 224px;
    margin: 0 auto;
}

#login form {
    margin: 0 0 20px;
    width: 253px;
    margin: 0 auto;
}
.members > a:nth-child(1){
  color: #fff !important;
}
/*ul.nav:nth-child(1) > li:nth-child(1) > a:nth-child(1) {
  color: #fff !important;
}*/
.main {
    background-color: #fff;
    border: none;
    box-shadow: none;
    min-height: 440px;
	width: 100%;
}

/*searchbox */

.mastheadsearch {
    background: #fff;
    /*border: 1px solid #e1e8ed;
    border-radius: 0;
    box-shadow: 0 4px 15px 0 rgba(0, 0, 0, 0.19);*/
    margin: 0 auto;
    overflow: hidden;
    width: 98%;
}

/*search text*/

.mastheadsearch label {
    color: #6CACE3;
    font-family: 'Roboto', sans-serif !important;
    font-weight: 500;
    font-size: 18px;
}
.librarypulldown .transl1 {
    width: 80%;
}
/*search button*/

#searchsubmit, .btn, .btn-primary {
    float: center !important;
    font-family: 'Roboto', sans-serif;
    display: inline;
    text-align: center;
    vertical-align: middle;
    cursor: pointer;
    font-size: 16px;
    height: 2.2em;
    text-shadow: none !important;
    margin-left: 3px;
    background: #fff !important;
    color: #57585C !important;
    border: 1px solid #fff !important;
    border-radius: 0px !important;
    position: relative;
    box-shadow: none !important;
}

#searchsubmit:hover, .btn-primary:hover, .btn:hover, .btn-small:hover, #placehold:hover, #login .btn:hover {
  text-decoration: none;

}

#searchform > label {
    display: none;
}

#searchform {
    display: block;
}

#searchsubmit {
    float: center;
}

#masthead_search {
    float: left;
}


#search-input-fill {
    display: block;
    overflow: hidden;
}

#moresearches {
    display: none;
    background-color: #F4F4F4;
    width: 8em;
    height: 3em;
    margin: auto !important;
    padding-top: 1.2em;
}
#moresearches a{
    color: #000;
    text-decoration: none;
    margin-top: 3em;
}
#moresearches :hover{
    border: 3px;
    border-color: #a9a9a9;
}

#moresearches li:after {
    content: "";
}

#moresearches li:nth-of-type(n+3) {
    display: none;
}
#translControl1 {
  padding-right: 0px !important;
}
input[type="text"]:focus, input[type="password"]:focus {
  border-color: #1F9BDE;
  box-shadow: inset 0 1px 1px rgba(31, 155, 222,.075),0 0 8px hsla(201,75%,50%,.6);
}

.input-append {
  float: right;
  margin-top:
}

#select_library {



}


#searchform > center:nth-child(4) > a:nth-child(2) {
  text-decoration: none;
}
#advsearch {
  background-color: #fff;

}
#advsearchbtn {
  font-family: 'Roboto', sans-serif;
  font-size: 16px;
  display: inline;
  margin-top: 3px;
  margin-left: 3px;
  padding: 12px 10px 11px 11px;
/*  vertical-align: middle;*/
  float: right;
  text-decoration: underline !important;
/*  background-color: #e3e3e3;*/
  color: #7B7D80 !important;
  border: 1px solid #fff;
}
#advsearchbtn:hover {
  color: #3A3A3D;
  text-decoration: none;
  /*border: 1px solid #57585C;*/
}
.btn-success {
  background: #e3e3e3 !important;
}
/* Search History*/

#searchhistory > h1:nth-child(1) {
  color: #57585C;
}


/*breadcrumb */

.breadcrumb {
    display: none;
    background-color: #ffffff;
    height: 40px;
    border: 1px solid #e1e8ed;
    border-radius: 0px;
    overflow: hidden;
    text-overflow: ellipsis;
    white-space: nowrap;
}

.breadcrumb > li {
    display: inline;
    *zoom: 1;
    text-shadow: none;
    margin-top: 10px;
    line-height: 40px;
}

.breadcrumb li a {
    font-family: 'Roboto', sans-serif;
    text-transform: uppercase;
    text-shadow: none;
    font-size: 14px;
    color: #0056B8;
    text-decoration: none;
}

/*=======================================================LANDING=PAGE=STYLES============================================================*/

/*Main Page - NEXT (BElOW SEARCH BAR)+++++++++++++++++*/
#opacmainuserblock {
  margin-right: -30%;
  margin-top: 2em;
}
.headline1 {
  height: 100px;
}
.headline2 {
  height: 110px;
}
/*============================More Suggestions Link, Hyperlink Under Curated Slideshow==========*/
.more_collections, .more_collections:visited {
 float: right;
 color: #7B7D80 !important;
 text-decoration: underline !important;
}



/*============================Helpful Links==================*/
.flex-container {
  display: flex;
  justify-content: space-around;
  align-items: center;
}
.widget1, .widget2, .widget3 {
  height: 200px;
  margin-top: 10px;
  }

.widget1 {
  margin-left: 7em;


}
.widget2 {



}
.widget3 {
 margin-right: -4em;
}


.neklscredit {
  float: right;
  padding-top: 5em;
  padding-bottom: 5em;
}

.w3-content > center:nth-child(1) > h4:nth-child(7) {
  font-weight: 700;
  margin-top: -1em;
  color: #4D4D4D;
  font-size: 16px;
}
button.w3-button:nth-child(5), button.w3-button:nth-child(6) {
  background: #4D4D4D !important;
}
button.w3-button:nth-child(5):hover, button.w3-button:nth-child(6):hover {
  background: #E3E3E3 !important;
  border: 1px solid #57585C !important;

}

/*
#opac-main > #wrap > .main {
    display: flex;
}

#opac-main > #wrap > .container-fluid > .row-fluid > #opac-main-search {
    left: 50%;
    position: relative;
    top: 57%;
    transform: translate(-50%, -75%);
    width: 100%;
}

#opac-main > #wrap > .container-fluid > .row-fluid > #opac-main-search > .span12 {
    margin: 0;
}

#opac-main > #wrap > .container-fluid > .row-fluid > #opac-main-search > .span12 > .mastheadsearch {
    width: 72%;
}

#search-input-fill > #translControl1 {
    width: 97%;
}

#opac-main > #wrap > .container-fluid > .row-fluid > #opac-main-search > .span12 > .row-fluid > #moresearches  {
    margin-right: 12.6%;
}


#opac-main > #wrap > #header-region > .container-fluid > .row-fluid > #opacheader > {
    margin: 10% auto 0;
}*/


/*=======================================================RESULTS===================================================================*/
/*Pop out table rows*/
.searchresults > #bookbag_form > table {
    border-collapse: separate;
    border-spacing: 1.5em;
}

.searchresults > #bookbag_form > .table th, .searchresults > #bookbag_form > .table td{
    border: none;
}

.searchresults > #bookbag_form > table > tbody > tr {
    box-shadow: 0 4px 15px 0 rgba(0, 0, 0, 0.19);
}

.coverimages {
    float: left;
    margin-top: 0.5%;
    width: 11em;

}
.item-thumbnail {
    padding: 0.5em;
    width: 70%;
    height: auto;
    box-shadow: 0 4px 15px 0 rgba(0, 0, 0, 0.19);
}
.item-thumbnail, td img {
    max-width: 150px;
}
span.no-image {
    width: 100px;
    height: 150px;
    display: none;
}

.title_resp_stmt {
    display: none;
}

.format_icon {
    float: left;
    margin-left: -100px;
    position: absolute;
    margin-top: -50px;
}

.format_icon img {
    width: 70%;
}

.star-rating-control {
    display: block;
    margin: 0.75em auto 0;
    width: 8em;
}

.results_summary.type {
    display: none;
}

.results_summary .label {
    display: none;
}

.results_summary.other_title {
    display: none;
}

.actions-menu.noprint {
    float: right;
}

.menu-collapse-toggle {
  border-radius: 0px !important;
  font-family: 'Roboto', sans-serif;
  font-size: 16px;
  font-weight: 400 !important;
  display: inline;
  background-color: #e3e3e3;
  color: #57585C;
}
.menu-collapse-toggle a:hover {
  color: #57585C !important;
}
#search-facets {
	box-shadow: 0 4px 15px 0 #E1E1E1;
	-webkit-border-radius: 0px;
	-moz-border-radius: 0px;
	border-radius: 0px !important;
  border: none;
}

.highlight_controls {
  display: none;
}
.highlight_controls::after{
  content: "Home Library"
}
.term {
  color: #57585C !important;
  background-color: #fff !important;
}
.rsssearchlink {
  display:none;
}
#tagsel_span {
  display: none;
}

a.tag_add{
  display:none;
}
#searchSHAREit {
    display: inline;
}

/*=======================================================DETAIL===================================================================*/
/*browse shelf*/

#shelfbrowser h5 {
    font-family: 'Roboto', sans-serif;
    text-transform: Captialize;
    text-shadow: none;
    font-size: 16px;
    color: #0056B8;
    text-decoration: none;

}

/*hide default images*/

#shelfbrowser #browser_next, #shelfbrowser #browser_previous {
    background-image: none;
    background-repeat: no-repeat;
    width: 24px;

}


#browser_previous > a:nth-child(1) {
  overflow: visible !important;
}


#browser_next > a:nth-child(1)
{
  overflow: visible !important;
}

/*=======================================================ACCOUNT-PAGES==================================================================*/
.table .nosort, .table .nosort.sorting, .table .nosort.sorting_asc, .table .nosort.sorting_desc, th {
    padding-right: 19px;
    background: #0056B8;
}

#usertags {
    background-color:#ffffff;
    padding:20px;
    border: 1px solid #e1e8ed;
}

#usertags .btn {
 border-radius:0px;
 margin-left:0px;
}

/*menu*/

#menu ul {
    padding: 0;
}

#menu li, #search-facets li {
    font-size: 90%;
    font-weight: 700;
    padding-left: 3%;
    width: 100%;
}

#usermenu #menu li a {
    background: #0056B8 !important;
    text-decoration: none;
    display: block;
    border-radius: 0px 0 0 0px;
    font-size: 111%;
    padding: 10px;
    margin: .4em 9px .4em 0;
    color: #ffffff !important;
    font-family: 'Roboto', sans-serif;
    font-size:14px;
    text-transform: capitalize;
}

#usermenu #menu li a:hover {
    color: #fff !important;
    background:  #57585C !important;
    background-color: #57585C !important;
}
#usermenu #menu li a:visited {
    color: #fff !important;

}
#save_3986498 {
  padding: 0px !important;
  color: #0056B8 !important;
  background-color: #fff !important;
}
/*user detail page */

.table .nosort, .table .nosort.sorting, .table .nosort.sorting_asc, .table .nosort.sorting_desc, th, td, .table-striped tbody > tr:nth-child(2n+1) > th:eq(1)  {
    padding-right: 19px;
    background: #0056B8;
}

.table-striped tbody > tr:nth-child(2n+1) > td, .table-striped tbody > tr:nth-child(2n+1) > th {
    padding-right: 19px;
    background: #0056B8;
}

.table-bordered caption + thead tr:first-child th, .table-bordered caption + tbody tr:first-child th, .table-bordered caption + tbody tr:first-child td, .table-bordered colgroup + thead tr:first-child th, .table-bordered colgroup + tbody tr:first-child th, .table-bordered colgroup + tbody tr:first-child td, .table-bordered thead:first-child tr:first-child th, .table-bordered tbody:first-child tr:first-child th, .table-bordered tbody:first-child tr:first-child td {
    border-top: 0;
    color: #fff;
    font-family: 'Roboto', sans-serif;
    font-size: 16px;
    font-weight: 300;
}

#renewcontrols a {
    font-family: 'Roboto', sans-serif;
    color: #0056B8;
    font-size: 16px;
    font-weight:400;
}

.table-striped tbody > tr:nth-child(2n+1) > td, .table-striped tbody > tr:nth-child(2n+1) > th {
    background-color: white;
    font-size: 16px;
    color:#000000;
}

.table td, .table th {
    line-height: 1.5;
    font-size: 16px;
}

/*fines */

.sum {
    font-family: 'Roboto', sans-serif;
}

/*update account */

#update-account {
    background-color: #ffffff;
    padding: 20px;
    border: 1px solid #e1e8ed;
}

th.sum {
    color: #ffffff;
}

/*change password*/

#userpasswd label {
    font-family: 'Roboto', sans-serif;
    color: #0056B8;
    font-size: 16px;
    padding-top:20px;
}

/*search history */

.table .sorting_desc {
    padding-right: 19px;
    background: url(../images/asc.gif) right center no-repeat #0056B8;
    color: #ffffff;
    font-family: 'Roboto', sans-serif;
    font-size: 16px;
    font-weight: 300;
}

#selections-toolbar, .selections-toolbar a {
    background: -moz-linear-gradient(top,#ffffff 0,#ffffff 14%,#ffffff 100%);
    background: -webkit-gradient(linear,left top,left bottom,color-stop(0,#ffffff),color-stop(14%,#ffffff),color-stop(100%,#ffffff));
    background: -webkit-linear-gradient(top,#ffffff 0,#ffffff 14%,#ffffff 100%);
    background: -o-linear-gradient(top,#ffffff 0,#ffffff 14%,#ffffff 100%);
    background: -ms-linear-gradient(top,#ffffff 0,#ffffff 14%,#ffffff 100%);
    background: linear-gradient(top,#ffffff 0,#ffffff 14%,#ffffff 100%);
    filter: progid:DXImageTransform.Microsoft.gradient(startColorstr='#e0e0e0', endColorstr='#e8e8e8', GradientType=0);
    margin: 0 0 1em;
    padding-top: .5em;
    padding-left: 10px;
    font-family: 'Roboto', sans-serif;
    font-size: 16px;
    font-weight: 400 !important;
    text-transform: none;
    color: #57585C !important;
    border: none !important;
}

#selections, .selections {
    font-weight: 400;
    font-size: 16px;
}

#userprivacy, #usersuggestions {
    background-color: #ffffff;
    padding: 20px;
    border: 1px solid #e1e8ed;
}

/*----- Changes text on "Your privacy" tab (opac-privacy.pl) to show simplified list of options -----*/
  /*----- Hides built-in options -----*/
    #opac-privacy-options-list > .privacy0, #opac-privacy-options-list > .privacy1 {
        display: none;
    }

    #opac-privacy-options-list > .privacy2 {
        visibility: hidden;
    }

  /*----- Changest the content of the discriptions -----*/
    #opac-privacy-options-list > .privacy2:before {
        content: "Previous 13 months: Reading history is kept for 13 months.  (All circulation transaction records are deleted 13 months after items are checked in.) \A Never: Reading history is deleted as soon as items are checked in. \A";
        white-space: pre-line;
        visibility: visible;
    }

  /*----- Hides "Never" from the drop-down (jQuery is required to change the name of the drop-downs) -----*/
    #privacy > .privacy0 {
        display: none;
    }


#opac-usersuggestions .toolbar.clearfix {
    width: inherit;
    float: none;
    position: static;
    bottom: 0px;
}

.toolbar {
    background-color: #EEE;
    border: 1px solid #E8E8E8;
    font-size: 100%;
    padding: 3px 3px 5px 5px;
    vertical-align: middle;
    text-transform: uppercase;
}

.toolbar #tagsel_tag, .toolbar .hold {
	padding-left: 28px;
	font-size: 97%;
	font-weight: 400;
}

#suggested_by_anyone {
    margin-right: 10px;
}

#opac-usersuggestions .btn {
    border-radius:4px;
}

#opac-usersuggestions input[type="text"] {
    background-color: #ffffff;
    border-top: 1px solid #E5E5E4;
    border-bottom: 1px solid #E5E5E4;
    -webkit-box-shadow: none;
    -moz-box-shadow: none;
    box-shadow: inset none;
    -webkit-transition: none;
    -moz-transition: none;
    -o-transition: border linear .2s, box-shadow linear .2s;
    transition: border linear .2s, box-shadow linear .2s;
    border-radius: 0 !important;
    height: 22px;
    padding: 10px;
    margin: 0px;
    width: 40% !important;
}

#opac-messaging .table-bordered tbody:first-child tr:first-child th {
    border-top: 0;
    color: #000000;
    font-family: 'Roboto', sans-serif;
    font-size: 16px;
    font-weight: 300;
}

.table .nosort, .table .nosort.sorting, .table .nosort.sorting_asc, .table .nosort.sorting_desc, th {
    padding-right: 19px;
    background: #0056B8;
    color: #ffffff;
    font-weight: 400 !important;
}

#login .btn {
  cursor: pointer;
  display: block;
  font-family: "Roboto",sans-serif;
  font-size: 16px;
  font-weight: 300;
  margin: 0 auto 2%;
  position: relative;
  text-align: center;
  text-shadow: none;
  text-transform: uppercase;
  vertical-align: middle;
  width: 49%;
  display: inline;
  margin-left: 3px;
  padding: 12px;
  background-color: #e3e3e3;
  color: #57585C;
  border: 1px solid #fff;
}

/*=======================================================FOOTER=========================================================================*/
#opaccredits {
    flex: 0 0 auto;
    width: 100%;
    margin-bottom: 50px;
}

#opaccredits a:hover {
    color: #6CACE3;
    text-decoration: none;
}

#opaccredits a:active, a:focus {
    text-decoration: none;
}

#mainfooter {
    min-height: 275px;
    padding: 0 1% 0;
}

#mainfooter a {
    color: #D5D5D5;
}

/*  SECTIONS  */
.footer-columns {
    clear: both;
    padding: 0px;
    margin: 0px;
}

/*  COLUMN SETUP  */
.ftcol {
    display: block;
    float:left;
    margin: 1% 0 1% 1.6%;
    padding-left: 1.6%;
}

.ftcol:first-child {
    margin-left: 0;
}

/*  GROUPING  */
.group:before,
.group:after { content:""; display:table; }
.group:after { clear:both;}
.group { zoom:1; /* For IE 6/7 */ }

/*  GRID OF FOUR  */
.ftspan_4 {
    width: 100%;
}

.ftspan_3 {
    width: 74.6%;
}

.ftspan_2 {
    width: 49.2%;
}

.ftspan_1 {
    width: 21.8%;
}
/*MEDIA QUERIES///////////////////////////////////////////*/


/*  WIDTH BELOW 968 PIXELS */
@media only screen and (max-width: 968px) {
#select_library {
display: none !important;
}
#searchsubmit {
  display: none !important;
}
.librarypulldown .transl1 {
	width: 100%;
}
#advsearchbtn {
/*  display: none;*/
}
}
/*  WIDTH BELOW 900 PIXELS */
@media only screen and (max-width: 900px) {
  .headline2 {
    margin-top: 0;
    margin-bottom: 2em !important;
    height: 100px;
  }
  .flex-container {
    flex-direction: column;
    margin-top: -75px;
  }
  .widget1, .widget2, .widget3 {
    margin: 0px !important;
    padding: 0px !important;
    margin-left: 33% !important;
  }
  .widget1 {
    margin-top: 2em !important;
  }

}

/*  WIDTH BELOW 768 PIXELS */
@media only screen and (max-width: 767px) {
  #opacmainuserblock {
    margin-right: 8px;
  }
.navbar {
  margin: 0px;
  }
#logo, #carticon {
  display: none;

}
}
/*  WIDTH BELOW 608 PIXELS */
@media only screen and (max-width:608px) {
  #searchsubmit {
    max-width: 290px !important;
    margin-top: -3em !important;
    margin-bottom: 1em !important;
    font-family: 'Roboto', sans-serif !important;
    font-weight: 400 !important;
}
  #advsearchbtn {
    padding-left: 82px;
    padding-right: 82px;
    margin-left: 0px;
  }
 /* .headline2 {
    margin-top: -4em !important;
  }*/
}
/*  WIDTH BELOW 350 PIXELS */
@media only screen and (max-width:350px) {
  #advsearchbtn {
    display: none;
  }
 .header2 {
    margin-top: 2em !important;
  }
  .headline1 {
  display: none;
  }

}
/*=======================================================FOOTER=========================================================================*/

/* -- gets rid of Marc and ISBD views on OPAC -- */
#catalogue_detail_biblio span.view:nth-child(2), #catalogue_detail_biblio span.view:nth-child(3) {display: none;}

/* hides availability box on results screen - GHW */
span.results_summary.availability {display: none;}

/* Hides active Flipster login when not logged in */
#notloggedin .flipin {display: none;}

/* Hides inactive Flipster login when logged in */
#loggedin .flipout {display: none;}




/* CSS for Koha CoverFlow Plugin
   This CSS was added automatically by installing the CoverFlow plugin
   Please do not modify */
.coverflow {
    height:160px;
    margin-left:25px;
    width:850px;
}

.coverflow img,.coverflow .item {
    -moz-border-radius:10px;
    -moz-box-shadow:0 5px 5px #777;
    -o-border-radius:10px;
    -webkit-border-radius:10px;
    -webkit-box-shadow:0 5px 5px #777;
    border-radius:10px;
    box-shadow:0 5px 5px #777;
    height:100%;
    width:100%;
}

.itemTitle {
    padding-top:30px;
}

.coverflow .selectedItem {
    -moz-box-shadow:0 4px 10px #0071BC;
    -webkit-box-shadow:0 4px 10px #0071BC;
    border:1px solid #0071BC;
    box-shadow:0 4px 10px #0071BC;
}
.userlabel, #carticon, .fa.fa-user.fa-icon-black.fa-fw {color: white;}
.col {background-color: white;}
.mastheadsearch {background-color: white !important;}
/* End of CSS for Koha CoverFlow Plugin */

/* e-card css */
#library_ecard{
 border: 4px solid gray;
 border-radius: 7px;
}

.fa-user-circle-o {
 font-size: 12vw !important;
 padding: 15px;
}

#barcode_placeholder {
 width: 90%;
}

#name_photo {
 display: flex;
 align-items: center;
}
/* end e-card css */






















