XX.IntranetUserCSS.txt

----------

Preference name: IntranetUserCSS

Type: free

Options: 

----------

Preference value: 



/* -- Re-brand the Koha staff interface version 23.06.30 -- */

/* root section sets Brand colors */

:root {

  /* Dark */
    --c_dark: #0157b9;
    --t_dark: #FFFFFF;

    --c_dark_hov: #04368e;
    --t_dark_hov: #FFFFFF;

  /* Medium */
    --c_medium: #1f9bde;
    --t_medium: #FFFFFF;

    --c_medium_hov: #0157b9;
    --t_medium_hov: #FFFFFF;

  /* Light */
    --c_light: #d7ebff;
    --t_light: #000000;

    --c_light_hov: #1f9bde;
    --t_light_hov: #FFFFFF;

  /* Colors for header */
    --c_head: #FFFFFF;
    --t_head: #000000;

    --c_head_hov: #e0e0e0;
    --t_head_hov: #000000;

  /* Text colors */

    --general_text: #000000;
    --general_link: #04368e;

  /* test colors - these are just colors I can pop in when I'm testing selectors */
    --testt: #FF0000;
    --textcolor: #000000;

}

/* All pages - highlighting */

  ::-moz-selection {
    background: var(--c_medium);
    color: var(--t_medium);
  }

  ::selection {
    background: var(--c_medium);
    color: var(--t_medium);
  }

/* -- All pages - header -- */

  /* Styles the header */
    .navbar,
    #header li a {
      background-color: var(--c_head);
      border: var(--c_head);
      color: var(--t_head) !important;
    }

  /* Styles header options on hover */
    #header #toplevelmenu li:nth-child(n):nth-child(-n+3):nth-child(-n+2):hover,
    #header #toplevelmenu li:nth-child(n+5):hover,
    #header #cartmenulink:hover,
    #header #cartmenulink:focus,
    #header #logged-in-menu:hover,
    #header #logged-in-menu:focus {
      background-color: var(--c_head_hov) !important;
      color: var(--t_head_hov) !important;
      border-radius: 16px;
    }

  /* Styles "Search" option and adjacent dropdown as one */
  /* Removes black line separator between "Search" and caret */
    #header #catalog-search-dropdown,
    #header #catalog-search-link,
    #header .dropdown-toggle {
      border: 0px;
    }

  /* Styles the "Search" link */
    #header #catalog-search-link:hover,
    #header #catalog-search-link:focus {
      background-color: var(--c_head_hov);
      border-top-left-radius: 16px;
      border-bottom-left-radius: 16px;
      border-right: 0px;
    }

  /* Styles the down-caret link on hover over the "Search" link */
    #header #catalog-search-dropdown>a.catalog-search-dropdown-hover,
    #header #catalog-search-dropdown>a.catalog-search-dropdown-hover:focus {
      background-color: var(--c_head_hov) !important;
      border-top-right-radius: 16px;
      border-bottom-right-radius: 16px;
      border-left: 0px;
    }

  /* Styles the search down-caret on hover  */
    #header #catalog-search-dropdown>a:hover,
    #header #catalog-search-dropdown>a:focus {
      background-color: var(--c_head_hov) !important;
      color: var(--t_head_hov) !important;
      border-top-right-radius: 16px;
      border-bottom-right-radius: 16px;
      border: 0px;
    }

  /* Styles dropdown content on hover or focus */
    #header ul .dropdown-menu li a:hover,
    #header ul .dropdown-menu li a:focus {
      background-color: var(--c_head_hov);
      color: var(--t_head_hov);
      border-radius: 0px;
    }

/* --- All pages - Search bar changes --- */

  /* Highlights input box in black on focus */
    #header_search .form-content:focus-within {
      box-shadow: inset 0px 0px 0px 4px #000000;
    }

  /* Adds padding to search bar to embiggen */
    #header_search {
      padding: 0.5em;
    }

  /* Styles search bar title area */
    #header_search .form-title {
      background-color: var(--c_dark);
      color: var(--t_dark);
      padding: 5px 16px 5px 16px;
      border-top-left-radius: 16px;
      border-bottom-left-radius: 16px;
    }

  /* Styles search bar title */
    #header_search .form-title label {
      background-color: var(--c_dark);
      color: var(--t_dark);
      margin: 0 auto;
    }

  /* Styles header search area */
    #header_search {
      border: 1px solid var(--c_medium);
      background-color: var(--c_medium);
      color: var(--t_medium);
    }

  /* Styles header search area buttons */
    #header_search ul {
      background-color: var(--c_medium);
      color: var(--t_medium);
    }

  /* Styles search type buttons */
    #header_search .nav-tabs>li>a {
      background-color: var(--c_medium);
      border: 1px solid var(--c_medium);
      color: var(--t_medium) border-radius: 16px;
      padding: 0.5em .8em;
    }

  /* Styles search type buttons on hover or focus */
    #header_search .nav-tabs>li>a:hover,
    #header_search .nav-tabs>li>a:focus,
    #header_search .nav-tabs>li>a:active {
      background-color: var(--c_medium_hov);
      border: 1px solid var(--c_medium_hov);
      color: var(--t_medium_hov);
      border-radius: 16px;
      padding: 0.5em .8em;
    }

  /* Styles search type buttons when selected */
    #header_search .nav-tabs>li.active a {
      background-color: var(--c_light);
      border: 1px solid var(--c_light);
      color: var(--t_light);
      padding: 0.5em .8em;
      border-radius: 16px;
      cursor: default;
    }

  /* Styles the submit button */
    #header_search button {
      background-color: var(--c_light) !important;
      color: var(--t_light) !important;
    }

  /* Styles the submit button on hover */
    #header_search button:hover {
      background-color: var(--c_dark_hov) !important;
      color: var(--t_dark_hov) !important;
    }

  /* Styles the filter icon on hover */
    div#header_search div.tab-content button.form-extra-content-toggle {
      background-color: transparent !important;
      color: black !important;
    }  

  /* Styles drop-down list on search catalog */
    .form-extra-content #idx {
      color: black !important
    } 

/* -- All pages - general stuff -- */

  /* Styles all default text in "--general_text" color */
    h1,
    h2,
    h3,
    h4,
    h5,
    h6,
    p,
    h1:hover,
    h2:hover,
    h3:hover,
    h4:hover,
    h5:hover,
    h6:hover,
    p:hover,
    a:hover,
    h1:focus,
    h2:focus,
    h3:focus,
    h4:focus,
    h5:focus,
    h6:focus,
    p:focus,
    a:focus {
      color: var(--general_text);
    }

  /* Styles all links in "--general_link" + underlines all links */
    a {
      color: var(--general_link);
      text-decoration: underline;
    }

  /* Styles links on hover */
    a:hover,
    a:focus {
      color: var(--t_light);
      background-color: var(--c_light);
      text-decoration: none;
    }

  /* Excludes logo and "Home" icon from link styles */
    #logo,
    #breadcrumbs ol li:nth-child(1) a,
    #breadcrumbs ol li:nth-child(1) a:hover {
      background-color: transparent;
      color: var(--general_link);
      text-decoration: none;
      border: 0px;
    }

/* -- Things that affect multiple pages -- */

  /* -- Tabs on tables -- */

    /* Style table tabs */
      .nav-tabs>li>a {
        background-color: var(--c_light);
        color: var(--t_light);
        border: 2px solid var(--c_light);
      }
    /* Style table tabs on hover */
      .nav-tabs>li>a:hover,
      .nav-tabs>li.active>a:hover {
        background-color: var(--c_light_hov);
        color: var(--t_light_hov);
        border: 2px solid var(--c_light_hov);
      }
    /* Style active table tab */
      .nav-tabs>li.active>a,
      .nav-tabs>li.active>a:focus {
        background-color: var(--c_dark);
        color: var(--t_dark);
        border: 1px solid black;
        border-bottom: 0px;
      }

/* -- Pages with sub-module bottons (circ/circulation-home.pl) (cataloguing/cataloging-home.pl) -- */

  /* Style sub-module buttons */
    .buttons-list li a:hover,
    .buttons-list li a:focus {
      background-color: var(--c_light_hov) !important;
      color: var(--t_light_hov) !important;
    }

/* -- Pages with left side menu -- */

  /* Styles title and heading left menu */
    #menu h5,
    #navmenulist h5 {
      color: var(--general_text);
    }
  /* Styles dormant links in left menu */
    #menu ul li a,
    #navmenulist ul li a {
      color: var(--general_link);
    }
  /* Styles currently selected left menu link */
    #menu ul li.active>a,
    #menu ul li a.current,
    #navmenulist ul li.active>a,
    #navmenulist ul li a.current {
      color: var(--general_link);
      border-left: solid 15px var(--c_medium);
    }
  /* Styles left menu links on hover */
    #menu ul li a:hover,
    #menu ul li a:focus,
    #navmenulist ul li a:hover,
    #navmenulist ul li a:focus,
    #menu ul li.active .pref_sublink:hover,
    #menu ul li.active .pref_sublink:focus {
      border-left: solid 20px var(--c_dark_hov) !important;
      background-color: var(--c_light);
      color: var(--t_light);
      font-weight: bold !important;
    }
  /* Styles sub-menu links on left menu */
  /* This seems to only be on (admin/preferences.pl) */
    #menu ul li.active .pref_sublink {
      color: var(--general_link);
      border-left: solid 10px var(--c_medium);
    }

/* -- Pages with datatables -- */

  /* Styles "Processing" pop-up message */
    .dataTables_wrapper .dataTables_processing {
      border: 2px solid var(--c_medium);
    }
  /* Styles pagination controls for datatables*/
  /* Styles active links and numbers */
    .dataTables_wrapper .dataTables_paginate .paginate_button {
      color: var(--general_link) !important;
    }
  /* Styles links and numbers on hover */
    .dataTables_wrapper .dataTables_paginate .paginate_button:not(.disabled):not(.current):hover {
      background-color: var(--c_light_hov) !important;
      color: var(--t_light_hov) !important;
    }
  /* Styles disabled links and numbers on hover */
    .dataTables_wrapper .dataTables_paginate .paginate_button.disabled:hover,
    .dataTables_wrapper .dataTables_paginate .paginate_button.current:hover {
      text-decoration: none !important;
    }
  /* Styles background color on currently selected number  */
    .dataTables_wrapper .dataTables_paginate .paginate_button.current {
      background: var(--c_light) !important;
    }

/* Style number box (members/members-home.pl) */

  /* Styles number box */
    .number_box a,
    .number_box span {
      background-color: var(--c_light);
      color: var(--t_light);
      border: 1px solid var(--t_light);
    }
  /* Styles number box on hover */
    .number_box a:hover,
    .number_box span:hover {
      background-color: var(--c_light_hov);
      color: var(--t_light_hov);
      border: 1px solid var(--t_light_hov);
    }

/* Style link buttons in link text */
  /* Check all and clear all buttons on (members/members-home.pl) */
  /* Options buttons on (catalogue/search.pl) */
    .btn.btn-link {
      color: var(--general_link);
    }

/* Style block pagination (authorities/authorities-home.pl?op=do_search . . . ) */

  /* Style page numbers */
    div.pages a:link,
    div.pages a:visited {
      background-color: var(--c_light);
      color: var(--t_light);
    }

  /* Style page numbers on hover */
    div.pages a:hover,
    div.pages a:active {
      background-color: var(--c_light_hov);
      color: var(--t_light_hov)
    }

  /* Style current page number */
    div.pages .current,
    div.pages .currentPage {
      background-color: var(--c_dark);
      color: var(--t_dark);
    }

/* Style Marc editor tabs (authorities/authorities.pl?authid=n) (cataloguing/addbiblio.pl?biblionumber=n) */

  /* Style Marc editor tabs */
    .toolbar-tabs li a {
      background-color: var(--c_light);
      border: 1px solid var(--c_light);
      border-right: 1px solid var(--c_light);
      color: var(--t_light);
    }
  /* Style Marc editor tabs on hover */
    .toolbar-tabs li a:hover {
      background-color: var(--c_dark_hov);
      border-bottom: 1px solid var(--c_dark_hov);
      ;
      border-right: 1px solid var(--c_dark_hov);
      ;
      color: var(--t_dark_hov);
      ;
    }
  /* Style Marc editor selected tab */
    .toolbar-tabs li.selected a {
      background-color: var(--c_medium);
      border-bottom: 1px solid var(--c_medium);
      ;
      border-right: 1px solid var(--c_medium);
      ;
      color: var(--t_medium);
    }

  /* Style Marc editor selected tab on hover */
    .toolbar-tabs li.selected a:hover {
      background-color: var(--c_medium_hov);
      color: var(--t_medium_hov);
    }

/* Home page (koha/mainpage.pl) */

  /* Home page - make module buttons Medium color on hover */
    ul.biglinks-list li a.icon_general:hover,
    ul.biglinks-list li a.icon_general:focus {
      background-color: var(--c_light_hov) !important;
      color: var(--t_light_hov) !important;
    }

/* Check out (circ/circulation.pl?borrowernumber=) */

  /* Style claims returned badges */
    #return-claims-count-resolved,
    #return-claims-count-unresolved {
      background-color: var(--c_light);
      color: var(--t_light);
      line-height: 1;
      font-size: 100%;
      font-weight: bold;
      border: 1px black solid;
    }

/* Check-in modal (circ/returns.pl) */

  /* Styles modal header and footer */
  .modal-header,
  .modal-footer {
    background-color: var(--c_light);
    border-bottom: 1px solid var(--c_light_hov);
    border-top: 1px solid var(--clight_hov)
  }

/* Authorities detail for . . . (authorities/detail.pl?authid=n) */

  /* Style tag number  */
    #authoritiestabs .tag_num {
      color: var(--general_text);
    }
  /* Style authority link spyglass (catalogue/detail.pl?biblionumber=n) */
    .authlink {
      background-color: var(--c_light) !important;
    }
  /* Styles "Clear search form" on Z39.50 search (cataloguing/z3950_auth_search.pl) */
    #resetZ3950Search {
      color: var(--general_link);
    }

/* Advanced catalog editor (cataloguing/editor.pl#catalog/n) */

  /* Style text */
    #cat_addbiblio .CodeMirror-code * {
      color: var(--general_link);
    }
  /* Style dropdown borders */
    .CodeMirror-widget .subfield-widget {
      border: solid 2px var(--general_link) !important;
    }
  /* Style select outline */
    .CodeMirror-widget .subfield-widget select:focus {
      outline: 0px var(--general_link) solid !important;
    }

/* Catalog search results  */

  /* Style search facets heading */
    #search-facets h4 {
      background-color: var(--c_medium);
      color: var(--t_medium);
    }
  /* Style "Hightlight"/"Unhighlight" */
    .highlight_toggle {
      color: var(--general_link) !important;
    }
  /* Style "Hightlight"/"Unhighlight" on hover */
    .highlight_toggle:hover {
      background-color: var(--c_light);
      color: var(-t_light) !important;
      border-radius: 6px;
    }

/* Search results (catalogue/search.pl?q=x) */

  /* Style page numbers */
    .pagination>li>a,
    .pagination>li>span {
      color: var(--t_light);
      background-color: var(--c_light);
    }

  /* Style page numbers on hover */
    .pagination>li>a:hover,
    .pagination>li>span:hover,
    .pagination>li>a:focus,
    .pagination>li>span:focus {
      color: var(--t_light_hov);
      background-color: var(--c_light_hov);
    }

  /* Style selected page number */
    .pagination>.active>a,
    .pagination>.active>span,
    .pagination>.active>a:hover,
    .pagination>.active>span:hover,
    .pagination>.active>a:focus,
    .pagination>.active>span:focus {
      color: var(--t_dark);
      background-color: var(--c_dark);
      border-color: var(--c_dark);
    }

/* Catalog search details (catalogue/detail.pl?biblionumber=n) */

  /* Browse results border */
    #browse-return-to-results {
      border: 1px solid var(--c_medium);
    }
  /* Browse results button border */
    .browse-button {
      background-color: rgba(0, 0, 0, 0);
      border: 1px solid var(--c_medium);
    }
  /* Browse results buttons */
    a.browse-button {
      color: var(--c_medium);
    }

/* System preferences message text pop-up (admin/preferences.pl) */
    .humanMsg p,
    #humanMsgLog p {
      color: var(--t_medium);
    }

/* Less well documented changes - kind of misc and odds and ends - better documentation coming soon */

/* Not 100% sure */
span.browse-button {
  color: var(--c_medium);
}

/* Patron lists */
/* Style "Select all" and "Clear all" buttons on Patron lists > NAME > Add patrons (patron_lists/list.pl?patron_list_id=n) */
/* Also affects (tags/review.pl?approved=) - added "Select all pending" */
#CheckAll,
#CheckNone,
#CheckPending {
  color: var(--general_link);
}

/* Styles dropdown lists in link text - not sure if it's comprehensive */
#toolbar ul li a {
  color: var(--general_link);
}

/* Styles border color on focus search page */
input:focus,
textarea:focus {
  border-color: var(--c_medium)
}

/* Catalog search details (catalogue/detail.pl?biblionumber=n) */

/* Browse results border */
#browse-return-to-results {
  border: 1px solid var(--c_medium);
}

/* Browse results button border */
.browse-button {
  background-color: rgba(0, 0, 0, 0);
  border: 1px solid var(--c_medium);
}

/* Browse results buttons */
a.browse-button {
  color: var(--c_medium);
}

/* Not 100% sure */
/* The old color is in the system, but I can't find a circumstance where it's applied to the page - added this css just to cover bases in case there's a situation where it does appear */
span.browse-button {
  color: var(--c_medium);
}

/* Style "Checked out" message */
div.lastchecked {
  border: 2px solid var(--c_medium);
}

/* Style "Approve" checkmark icon in override dialogue */
.dialog .approve i {
  color: var(--c_dark);
}

/* Style links in datepicker */
.shortcut-buttons-flatpickr-button {
  color: var(--c_dark) !important;
}

/* Style buttons when paying fee (members/paycollect.pl) */
.nav-pills li.active a:link,
.nav-pills li.active a:visited {
  background-color: var(--c_medium);
  color: var(--t_medium);
}

/* Style buttons on hover when paying fee (members/paycollect.pl) */
.nav>li>a:hover,
.nav>li>a:focus {
  background-color: var(--c_medium_hov);
  color: var(--t_medium_hov);
}

/* Styles "Drop files . . . " link on hover (tools/upload-cover-image.pl) */
#click_to_select:hover {
  background-color: var(--c_dark_hov);
  color: var(--t_dark_hov);
  border-radius: 16px;
  padding-left: 16px;
  padding-right: 16px;
}

/* About page - green "success" highlight (koha/about.pl) - may affect other pages */
.bg-success {
  background-color: var(--c_light);
  color: var(--t_light);
}

/* Update patron records (members/members-update.pl) */
/* Also affects column configuration (admin/columns_settings.pl) */

/* Style links in panels */
.panel-body a {
  color: var(--general_link);
}

/* Style titles on hover */
.panel-title a:hover,
.panel-title a:focus {
  background: var(--c_medium_hov) none;
  color: var(--t_medium_hov)
}

/* Style panel when selected */
.panel-title a:not(.collapsed) {
  background: var(--c_dark) none;
  color: var(--t_dark)
}

/* Style panel  */
.panel-title a:not(.collapsed):hover,
.panel-title a:not(.collapsed):focus {
  background: var(--c_dark_hov) none;
  color: var(--t_dark_hov)
}

/* Style panel title when collapsed and hover */
.panel-title a.collapsed:hover,
.panel-title a.collapsed:focus {
  background: var(--c_light_hov) none;
  color: var(--t_light_hov)
}

/* Style panel when closed */
.panel-default {
  border: 1px solid var(--t_light)
}

/* Style panel heading */
.panel-default>.panel-heading {
  background: var(--c_light) none;
  color: var(--t_light)
}

/* Style panel sub-text */
.panel-default>.panel-heading+.panel-collapse>.panel-body {
  border-top-color: var(--t_light);
}

/* Did you mean configuration (admin/didyoumean.pl) */
/* Styles plugin titles */
.pluginname {
  background-color: var(--c_light);
}

/* Style the flatpickr border (Affects many pages including tools/holidays.pl) */
.flatpickr-calendar {
  border: 1px solid var(--c_dark);
}

/* Style the panel border (affects many pages including tools/holidays.pl) */
.panel {
  border: 1px solid var(--c_dark);
}

/* Pages with toolbars (members/moremember.pl) (cataloguing/cataloging-home.pl) (labels/label-home.pl) (tools/automatic_item_modification_by_age.pl) (tools/automatic_item_modification_by_age.pl?op=edit_form) */
/* Style toolbar buttons */
#toolbar .btn.btn-default,
.btn-toolbar .btn.btn-default {
  color: var(--general_link);
  padding: 6px 12px;
  border: 1px dotted transparent;
}

/* Style toolbar buttons on hover */
#toolbar .btn.btn-default:hover,
#toolbar .btn.btn-default:focus,
.btn-toolbar .btn.btn-default:hover,
.btn-toolbar .btn.btn-default:focus {
  text-decoration: none;
  background-color: #dadada;
  border: 1px dotted dimgray;
  color: var(--general_text);
  padding: 6px 12px;
}

/* -- END Re-brand the Koha staff interface -- */

/* -- Next Search Catalog customizations -- */

/* Home > Patrons (members/member.pl) */
  /* Style borrower's home library as pill if home library = current library */
    #memberresultst_search_results .currentlibrary {
      background-color: var(--c_light);
      color: var(--t_light);
      padding: 5px 16px 5px 16px;
      border-radius: 16px;
      font-weight: 600;
    }

/* Home > Cataloging > Editing {Title} (Record number {biblionumber}) > Items (/cataloguing/additem.pl?biblionumber={biblionumber}) */
  /* BEGIN adds light color to local rows in add/edit items */
  /* Requires IntranetUserJS "prevent edit and delete of non-local items" */
    #cat_additem #itemst .local.even td {
      background-color: var(--c_light_hov);
      color: var(--t_light_hov);
      font-weight: 600;
    }
    #cat_additem #itemst .local.odd td {
      background-color: var(--c_light);
      color: var(--t_light);
      font-weight: 600;
    }

/* Home > Reports > Guided reports wizard > Saved reports (reports/guided_reports.pl?phase=Use saved) */
  /* Report show tabs and table after table has finished loading */
  /* (Requires IntranetUserJS "Report show tabs and table") */  
    #rep_guided_reports_start #tabs {
      display: none;
    } 

/* Circulation (circ/circulation-home.pl) */  
  /* Style offline circulation links like buttons */
    /* Creates button effect */
      #offline-circulation p  {
        background-color: #e0e0e0;
        padding: 10px;
        border-radius: 6px;
      }
    /* Style text of circulation links buttons */
      #offline-circulation a {
        color: black;
      }
    /* Style offline circulation buttons on hover */
      #offline-circulation p:hover,
      #offline-circulation p:hover a {
        background-color: var(--c_light_hov) !important;
        color: var(--t_light_hov) !important;
        border: 0px solid black !important;
      }

/* Home > Catalog > TITLE > Place a hold */
  /* remove the "Clear date" X from all date fields on the holds page */
    #circ_request .clear_date {display: none;}

/* Sets maximum size for item type and collection code icons on many pages */
  /* Home > Advanced search */
    #advsearch-tab-ccode_panel img, #advsearch-tab-itemtypes_panel img {max-width: 50px; max-height: 50px;}

  /* Home > Catalog > TITLE > Details */
    #holdings_table img {max-width: 50px; max-height: 50px;}

  /* Home > Administration > Item types administration */
    #table_item_type img {max-width: 50px; max-height: 50px;}

/* Reports > Guided reports wizard > Saved reports  */
 /* Hides reports with the word "ADMINREPORT in the title or notes */   
  .adminreport {display: none;}
  .reportinfo {border: 2px solid black; padding: 10px 10px 10px 10px; border-radius: 10px;}
  .page-section .reportinfo {background-color: yellow; font-size: 122.5%}

/* Catalog › Search for SEARCHTERMS (catalogue/search.pl) */
  /* Removes "No image available" placeholders in search results */
    .no-image {
        display: none;
    }

/* Home > Catalog > TITLE > Details (catalogue/detail.pl) */
  /* Re-flows contents of "Item type" cell on table to make longer text flow better */
    .itypedesc {display: flow-root;}

/* Home > Catalog > TITLE > Details (catalogue/detail.pl) */
  /* Limits the size of the item type icons */
    #holdings_table td[class^='itype sorting'] img {max-width: 75px;}

/* Home > Catalog > TITLE > Place a hold */
  /* Remove hold cancelation checkboxes (i.e. prevent batch cancellation of requests) */
    #circ_request .select_hold_all, 
    #circ_request .select_hold, 
    #circ_request .cancel_selected_holds {
      display: none;
    }

/* Multiple pages including: */
/* Home > Circulation > Checkouts > NAME (CARDNUMBER) (circ/circulation.pl) */
/* Home > Circulation > Checkout to NAME (CARDNUMBER) > Batch check out (circ/circulation.pl) */
/* Home > Patrons > NAME (CARDNUMBER) > Details (members/moremember.pl) */
/* Home > Patrons > NAME (CARDNUMBER) > Make a payment (members/pay.pl) */
/* Home > Patrons > NAME (CARDNUMBER) > Subscription routing lists (members/routing-lists.pl) */
/* Home > Patrons > NAME (CARDNUMBER) > Circulation history (members/readingrec.pl) */
/* Home > Patrons > NAME (CARDNUMBER) > Holds history (members/holdshistory.pl) */
/* Home > Logs > Results (viewlog.pl?do_it=1&modules=MEMBERS) */
/* Home > Patrons > NAME (CARDNUMBER) > Sent notices (members/notices.pl) */
/* Home > Patrons > NAME (CARDNUMBER) > Statistics (members/statistics.pl) */
/* Home > Patrons > NAME (CARDNUMBER) > Files (members/files.pl) */
/* Home > Patrons > NAME (CARDNUMBER) > Purchase suggestions (members/purchase-suggestions.pl) */
  /* Embiggens the text in the brief info section */
  .patronbriefinfo {
    font-size: 1.1em;
  }

/* All pages with CodeMirror */
  /* Embiggen CodeMirror windows to full height */
    div.CodeMirror {height: auto;}

/* Embiggen and bolden autoswitched message (circ/circulation.pl) */
  #autoswitched {
    background: yellow; 
    font-size: 1.5em; 
    border: 2px solid black; 
    border-radius: 8px
  }

/* Style tab buttons on add/edit biblio (cataloguing/addbiblio.pl) */
  #cat_addbiblio ul.nav-tabs li a {
    background-color: var(--c_light);
    color: var(--t_light);
  }
  
  #cat_addbiblio ul.nav-tabs li a:hover {
    background-color: var(--c_light_hov);
    color: var(--t_light_hov);
  }
  
  #cat_addbiblio ul.nav-tabs .active.selected a {
    background-color: var(--c_dark);
    color: var(--t_dark);
  }
  
  #cat_addbiblio ul.nav-tabs .active.selected a:hover {
    background-color: var(--c_dark_hov);
    color: var(--t_dark_hov);
  }



/* RAW FROM 22.05 */



/* .pat #RenewCheckinChecked, .pat #RenewAll, .pat label[for=override_limit], .pat #override_limit {display: none;} */
.permhighlight, .permhighlight .child-flags {background: yellow !important}

/* Remove hold cancelation checkboxes */
#circ_request .select_hold_all, #circ_request .select_hold, #circ_request .cancel_selected_holds {display: none;}

/* Remove remove hold start date x */
#circ_request .request_expiration_date .clear_date {display: none;}


/*  */
.patronbriefinfo {font-size: 110%;}

/* Add a class for "updated" */
.updated {background-color: red; color: white;}

/* Hide auto-renewal checkbox */
#set-automatic-renewal {display: none}

/* BEGIN - Fix button problem on tools_batchMod-edit tools_stage-marc-import admin_preferences */
.main {padding-bottom: 50px;}

.checkout-settings {background-color: pink;}

#bookcoverimg img , [id^="coce-thumbnail"] > img, #coce-thumbnail-preview .thumbnail
 {max-width: 100px;}

.sqlnotes {overflow-y: hidden; padding-top: 1.1em;}

/* Catalog > Details for -TITLE- */
 td.status span.dmg, td.status span.lost, td.status span.noloan, td.status span.wdn {color: yellow; font-size: 115%;}
 td.status span.intransit {color: black; font-size: 115%;}
 td.status span.waiting-hold {color: black; font-size: 115%;}

.mrq {color: red;}

/* CATHOVER_CSS - requires CATHOVER_JQ */
.cathover {background-color: #edeff1;}

/* pushes search resulst table underneath searchheader so that TH isn't hidden */
#searchresults {padding-top: 10px}

.contents_s {text-align: left; display: block;}
.contents_s h2 {color: blue;}

.contents_h {text-align: left; display: none;}
.contents_h h2 {color: blue;}


.minortr th {background-color: yellow !important;}

.clicked {color: inherit; background-color: inherit;}
.clicked:visited {color: white; background-color: black;}

#lrrow td {background-color: yellow !important;}


/* KOHA > Login screen */
 /* hide upgrade notes */
  .upgrade1 {text-align: center; color: #ff0000;}
  .upgrade2 {text-align: center; color: #ff0000; display: none;}
  .highlight {background-color: #ffff00;}

 /* hide branch dropdown */
  #main_auth #loginform label[for*='branch'] {display: none;}
  #main_auth #login #loginform #branch {display: none;}

/* KOHA > * (all pages) */
 /* Hide My Account and My Checkouts from drop-down menu */
  .toplinks-myaccount, .toplinks-mycheckouts {display: none;}

 /* disable Firefox screenshots */
  #firefox-screenshots-preselection-iframe {display: none !important;}

/* Home > Advanced search */
 /* Advanced search - hide subtype filters */
  #subtype {display: none;}

/* Home > Administration > Circulation and fine rules */
 /* disable rule cloning */
  #admin_smart-rules #doc3.yui-t1 #yui-main div.yui-b:nth-child(1) > div:nth-child(3) > form:nth-child(2) {display: none;}


/* Cart */
 /* Removes the "Batch delete" link from the cart */
  #cart_basket #bookbag_form #batch_delete {display: none;}

/* Catalog > Details for TITLE */
 /* Hides many links */
  #batchedit,
  #batchdelete,
  #deleteallitems,
  #batchedit-disabled,
  #batchdelete-disabled,
  #deleteallitems-disabled
   {display: none;}

/* Circulation > Checkouts */
 /* Hide automatic renewals checkbox */
  /*#circ_circulation #set-automatic-renewal {display: none;}*/


.rep .yui-t1 #bd #yui-main .yui-b td .reportinfo {font-size: inherit; font-weight: inherit; background-color: inherit;}
.rep .yui-t1 #bd #yui-main .yui-b .reportinfo {font-size: 14px; font-weight: normal; background-color: #FFFF66;}


#toplevelnav {
float: left;
margin-left: .5em;
width: 60em;
}

#circ_circulation .ColVis.TableTools {
display: none;
}

.results_summary {
font-size: 100%;
color: #000000;
line-height: 14px;
}

.results_summary .label {
font-weight: bold;
color: #000;
}

.results_summary.subjects {
font-size: 85%;
}

.results_summary.contents {
font-size: 85%;
}
.results_summary.online_resources {
font-size: 85%;
}

h5.author {
font-size: 110% !important;
}


.dropdown-menu ul li ul{
   max-height:250px;
   overflow-x:hidden;
   overflow-y:auto;
}

/* -Home- Changes background of the news area (makes it easier to read) */
#area-news {
    background-color: #E0ECF8;
}

/* -Administration › Circulation and fine rules- hides columns in circulation rules (requires accompanying jQuery) */
th.hiderule, td.hiderule {
    min-width: 15px;
    max-width: 15px;
    text-indent: -9999px;
}

/* -Catalog > Details for TITLE- for collapsing "Contents" area - (requires corresponding jQuery) */
  #show_content {
    color: #004d99;
    display: inline;
    font-weight: normal;
    padding-left: 5px;
  }

/* - Catalog › Search for SEARCHTERMS- Removes "No image available" placeholders in search results */
  .no-image {
    display: none;
  }

div.lastchecked {
  background-color: lightgreen;
}


/* -Circulation › Checkouts › -PATRONNAME-- and all other pages with the "patroninfo" block - highlights patron attributes in yellow */
/* .patronattribute {background-color: #ffff00;} */


/* Patrons */
#pat_member div.btn-group:nth-child(2) {display: none;}


/* Custom styles here */ 

#merge-patrons {display: none;} 

#sql {min-height: 500px !important;}
#notes {min-width: 1000px !important; min-height: 250px !important;}


/*.adminreport {display: none;}*/

.nsystem_stop {padding: 10px; border: 5px solid red;}
.nsystem_caut {padding: 10px; border: 5px solid yellow;}
.nsystem_go {padding: 10px; border: 5px solid green;}
.nlinks {padding: 10px; border: 5px solid aqua;}
.nprof {padding: 10px; border: 5px solid mediumpurple;}
.ncontact {padding: 10px; border: 5px solid midnightblue;}
.ntraining {padding: 10px; border: 5px solid orange;}

.nsystem_go {font-size: 1.15em}

#blockedpatron {background-color: yellow; border-radius: 10px;}
#dontedit {background-color: red; color: white; visibility: none; border-radius: 10px;}
#cphighlight {outline: 7px solid green; background-color: green; color: white;}

.closedforsummer {color: red;}

/* Administration > Transport cost matrix */
 /* Makes headers for Emporia Hub Libraries appear red and KC blue and Topeka green (requires corresponding jQuery) */
  .emporiahub {color: red;}
  .kansascityhub {color: blue;} 
  .topekahub {color: green;}

/* Reports > Guided reports wizard > Saved reports  */
 /* Hides reports with the word "ADMINREPORT in the title or notes */   
  .adminreport {display: none;}
  #reportinfo {border: 2px solid black; padding: 10px 10px 10px 10px; border-radius: 10px;}
  #reportnotes #reportinfo {background-color: yellow; font-size: 122.5%}

#newst td:nth-child(9){max-width: 75px;}

#pat_member #patron_updates_pending {display: none;}

#rep_guided_reports_start #tabs, #circ_circulation #patronlists, #acq_suggestion #suggestiontabs {
    display: none;
  }

/* Sets maximum size for item type and collection code icons in the staff client */
  #table_item_type img, #advsearch-ccode img, #advsearch-itemtypes img {max-width: 75px; max-height: 75px;}



/* Next Search Catalog buttons */

  .next_btn {
    padding: .5em;
    border: 1px solid #555;
    border-radius: 4px;
    display: inline-block;
    font-weight: normal;
    line-height: 1.42857143;
    margin-bottom: 0;
    text-align: center;
    vertical-align: middle;
    white-space: nowrap;
  }
  
  .next_green {
    background: #9eef8f none;
    color: black;
  }
  
  .next_green:hover {
    background: #3ce01f none;
    color: black;
  } 
  
  .next_yellow {
    background: #efe18f none;
    color: black;
  }
  
  .next_yellow:hover {
    background: #e0c422 none;
    color: black;
  }
  
  .next_red {
    background: #ef8f9e none;
    color: black;
  }
    
  .next_red:hover {
    background: #e0223e none;
    color: black;
  }
  
  .next_purple {
    background: #e18fef none;
    color: black;
  }
  
  .next_purple:hover {
    background: #c31fe0 none;
    color: white;
  }

  .next_dark {
    background: #0157b9;
    color: #FFFFFF;
  }

  .next_dark:hover {
    background: #04368e;
    color: #FFFFFF;
  }

  .next_medium {
    background: #1f9bde;
    color: #FFFFFF;
  }

  .next_medium:hover {
    background: #0157b9;
    color: #FFFFFF;
  }

  .next_light {
    background: #d7ebff;;
    color: #000000;
  }

  .next_light:hover {
    background: #1f9bde;
    color: #FFFFFF;
  }


/* Next Search Catalog labels */
  .next_label_green {
    background: #9eef8f none;
    color: black;
    padding-left: .75em;
    padding-top: .25em;
    padding-right: .75em;
    padding-bottom: .25em;
    border-radius: 16px;
    display: inline-block;
    font-weight: normal;
    line-height: 1.42857143;
    margin-bottom: 0;
    text-align: center;
    vertical-align: middle;
    white-space: nowrap;
  }
  
  .next_label_yellow {
    background: #efe18f none;
    color: black;
    padding-left: .75em;
    padding-top: .25em;
    padding-right: .75em;
    padding-bottom: .25em;
    border-radius: 16px;
    display: inline-block;
    font-weight: normal;
    line-height: 1.42857143;
    margin-bottom: 0;
    text-align: center;
    vertical-align: middle;
    white-space: nowrap;
  }
  
  .next_label_red {
    background: #ef8f9e none;
    color: black !important;
    padding-left: .75em;
    padding-top: .25em;
    padding-right: .75em;
    padding-bottom: .25em;
    border-radius: 16px;
    display: inline-block;
    font-weight: normal;
    line-height: 1.42857143;
    margin-bottom: 0;
    text-align: center;
    vertical-align: middle;
    white-space: nowrap;
  }
  
  .next_label_purple {
    background: #e18fef none;
    color: black;
    padding-left: .75em;
    padding-top: .25em;
    padding-right: .75em;
    padding-bottom: .25em;
    border-radius: 16px;
    display: inline-block;
    font-weight: normal;
    line-height: 1.42857143;
    margin-bottom: 0;
    text-align: center;
    vertical-align: middle;
    white-space: nowrap;
  }

  .next_label_dark {
    background: #0157b9 none;
    color: #FFFFFF;
    padding-left: .75em;
    padding-top: .25em;
    padding-right: .75em;
    padding-bottom: .25em;
    border-radius: 16px;
    display: inline-block;
    font-weight: normal;
    line-height: 1.42857143;
    margin-bottom: 0;
    text-align: center;
    vertical-align: middle;
    white-space: nowrap;
  }

  .next_label_medium {
    background: #1f9bde none;
    color: #FFFFFF;
    padding-left: .75em;
    padding-top: .25em;
    padding-right: .75em;
    padding-bottom: .25em;
    border-radius: 16px;
    display: inline-block;
    font-weight: normal;
    line-height: 1.42857143;
    margin-bottom: 0;
    text-align: center;
    vertical-align: middle;
    white-space: nowrap;
  }

  .next_label_light {
    background: #d7ebff none;
    color: #000000;
    padding-left: .75em;
    padding-top: .25em;
    padding-right: .75em;
    padding-bottom: .25em;
    border-radius: 16px;
    display: inline-block;
    font-weight: normal;
    line-height: 1.42857143;
    margin-bottom: 0;
    text-align: center;
    vertical-align: middle;
    white-space: nowrap;
  }

/* News block outlines */
  .news_green {
    padding: 10px;
    border: 5px solid #9eef8f;
  }
  
  .news_yellow {
    padding: 10px;
    border: 5px solid #efe18f;
  }
  
  .news_red {
    padding: 10px;
    border: 5px solid #ef8f9e;
  }
  
  .news_purple {
    padding: 10px;
    border: 5px solid #e18fef;
  }

/* Embiggen any text element */
  .embiggen_10 {font-size: 110%}

@media print {
  .noprint {
    display: none;
  }
}





















