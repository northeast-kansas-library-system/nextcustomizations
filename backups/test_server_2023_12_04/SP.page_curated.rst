SP.page_curated.txt

----------

Preference name: page_curated

Type: Textarea

Options: 80 | 50

----------

Preference value: 



<style>
body {
overflow-x: hidden;
}

.page-adjust {
margin-right: 23%;
}
 h4 {
    color: #606060;
    font-size: 20px;
  }

  p {
    color: #606060;
    font-size: 16px;
  }

  a,
  a:visited {
    color: #0056B8;
    font-size: 16px;
  }

  #columns {
    column-width: 200px;
    column-gap: 15px;
    width: 90%;
    min-width: 326px;
    max-width: 980px;
    margin: 50px auto;
  }

  #columns2 {
    column-width: 400px;
    column-gap: 15px;
    width: 90%;
    min-width: 326px;
    max-width: 1280px;
    margin: 50px auto;
  }

  div#columns figure {
    background: #fefefe;
    border: 2px solid #fcfcfc;
    box-shadow: 0 1px 2px rgba(34, 25, 25, 0.4);
    margin: 0 2px 15px;
    padding: 15px;
    padding-bottom: 10px;
    transition: opacity .4s ease-in-out;
    display: inline-block;
    column-break-inside: avoid;
  }

  div#columns figure:hover {
    border-color: rgba(82, 168, 236, 0.8);

    */ -webkit-box-shadow: inset 0 1px 1px rgba(0, 0, 0, .075),
    0 0 8px div#columns figure img {
      width: 100%;
      height: auto;
      border-bottom: 1px solid #ccc;
      padding-bottom: 15px;
      margin-bottom: 5px;
    }

    div#columns figure figcaption {
      font-size: .9rem;
      color: #444;
      line-height: 1.5;
    }

    div#columns small {
      font-size: 1rem;
      float: right;
      text-transform: uppercase;
      color: #aaa;
    }

    div#columns small a {
      color: #666;
      text-decoration: none;
      transition: .4s color;
    }

    div#columns:hover figure:not(:hover) {
      opacity: 0.4;
    }

  }

  @media screen and (max-width: 750px) {
    #columns {
      column-gap: 5px;
    }

    #columns figure {
      width: 70%;
    }
  }

  @media screen and (max-width: 750px) {
    #columns figure {
      width: 90%;
    }

  }
</style>

<body>
<div class="page-adjust">
  <center><img height="90" width="395" src="https://nekls.org/wp-content/uploads/2018/08/headlines.next_.opac_.8.14.18.png"></center>

  <div id="columns">

    <figure>
      <a href="/cgi-bin/koha/opac-search.pl?advsearch=1&idx=ti%2Cphr&q=street+date&weight_search=on&do=Search&searchcat=N_VID&sort_by=relevance">
      <img width="100%" src="https://nekls.org/wp-content/uploads/2019/05/up.next_.video_.png"></a>
      <figcaption><b>Movies & TV Series</b><br>These titles are coming to Next in the coming weeks and months, reserve your place in line today.</figcaption>
    </figure>
    <figure>
      <a href="/cgi-bin/koha/opac-search.pl?advsearch=1&idx=kw&q=a&op=not&idx=ti%2Cphr&q=street+date&weight_search=on&searchcat=N_VID&sort_by=acqdate_dsc&limit-yr=2021-&do=Search">
      <img width="100%" src="https://nekls.org/wp-content/uploads/2018/08/new.releases.video_.2.png"></a>
      <figcaption><b>Movies & TV Series</b><br>These titles are now in circulation at Next Libraries. Reserve something new to watch today.</figcaption>
    </figure>
    <figure>
      <a href="/cgi-bin/koha/opac-search.pl?&limit=mc-itype%2Cphr%3AGAME&limit=yr%2Cst-numeric%3D2016-&offset=25&sort_by=acqdate_dsc">
      <img width="100%" src="https://nekls.org/wp-content/uploads/2018/08/new.releases.games_.png"></a>
      <figcaption><b>Video Games</b><br>These titles are now in circulation at Next Libraries. Reserve something new to play today.</figcaption>
    </figure>
    <figure>
      <a href="/cgi-bin/koha/opac-search.pl?idx=ti%2Cphr&q=street+date&limit=mc-itype%2Cphr%3ABOOK&limit=mc-itype%2Cphr%3ALOCALHOLD2&limit=mc-itype%2Cphr%3APBBKNEW&limit=mc-itype%2Cphr%3APBBKWALK&sort_by=acqdate_dsc&addto=Add+to...">
      <img width="100%" src="https://nekls.org/wp-content/uploads/2019/05/up.next_.books_.png"></a>
      <figcaption><b>Books</b><br>These titles are coming to Next in the coming weeks and months, reserve your place in line today.</figcaption>
    </figure>
  </div>
  <center><img height="90" width="395" src="https://nekls.org/wp-content/uploads/2018/08/curated.archive.png"></center>
  <div id="columns2">

    <center>
      <h4>Audiobooks</h4>
    </center>
    <p>
      <ul>
        <li><a href="/cgi-bin/koha/opac-search.pl?advsearch=1&idx=kw&q=a&op=not&idx=ti%2Cphr&q=street+date&weight_search=on&searchcat=N_AUD&sort_by=acqdate_dsc&limit-yr=2021-&do=Search">New</a>: Audiobooks that have recently been added to the Next: search catalog.</li>
      </ul>
    </p>

    <center>
      <h4>Books</h4>
    </center>
    <p>
      <ul>
        <li><a href="/cgi-bin/koha/opac-search.pl?advsearch=1&idx=ti%2Cphr&q=street+date&weight_search=on&do=Search&searchcat=P_BBK&sort_by=acqdate_dsc">Up Next</a>: Books that will be available in the coming months, reserve your place in line.</li>

        <li><a href="/cgi-bin/koha/opac-search.pl?advsearch=1&idx=kw&q=a&op=not&idx=ti%2Cphr&q=street+date&weight_search=on&do=Search&limit=mc-ccode%3AFICTION&searchcat=P_BBK&limit=mc-loc%3AADULT&sort_by=acqdate_dsc&limit-yr=2021-&do=Search">New Adult</a>: New fiction books for adults that have been recently added to Next: search catalog.</li>

        <li><a href="/cgi-bin/koha/opac-search.pl?advsearch=1&idx=kw&q=a&op=not&idx=ti%2Cphr&q=street+date&weight_search=on&searchcat=P_BBK&limit=mc-loc%3ACHILDRENS&sort_by=acqdate_dsc&limit-yr=2021-&do=Search">New Kids</a>: New books for children that have been recently added to Next: search catalog.</li>

        <li><a href="/cgi-bin/koha/opac-search.pl?advsearch=1&idx=kw&q=a&op=not&idx=ti%2Cphr&q=street+date&weight_search=on&limit=mc-ccode%3ALARGEPRINT&limit=mc-ccode%3ALARGEPRNF&searchcat=P_BBK&sort_by=acqdate_dsc&limit-yr=2021-&do=Search">New Large Print</a>: New books, with large print, that have been recently added to Next: search catalog.</li>

        <li><a href="/cgi-bin/koha/opac-search.pl?advsearch=1&idx=kw&q=a&op=not&idx=ti%2Cphr&q=street+date&weight_search=on&limit=mc-ccode%3ABIOGRAPHY&limit=mc-ccode%3AEDUCATION&limit=mc-ccode%3ALARGEPRNF&limit=mc-ccode%3ANONFICTION&searchcat=P_BBK&limit=mc-loc%3AADULT&sort_by=acqdate_dsc&limit-yr=2021-&do=Search">New Nonfiction</a>: New nonfiction books for adults that have been recently added to Next: search catalog.</li>

        <li><a href="/cgi-bin/koha/opac-search.pl?advsearch=1&idx=kw&q=a&op=not&idx=ti%2Cphr&q=street+date&weight_search=on&searchcat=P_BBK&limit=mc-loc%3AL_YA&sort_by=acqdate_dsc&limit-yr=2021-&do=Search">New Young Adult</a>: New books for young adults that have been recently added to Next: search catalog.</li>
        
        <li><a href="/cgi-bin/koha/opac-search.pl?advsearch=1&idx=su%2Cphr&q=guidebooks&op=or&idx=su%2Cphr&q=travel&op=not&idx=ti%2Cphr&q=Street+date&weight_search=on&limit=mc-ccode%3ANONFICTION&searchcat=P_BBK&limit=mc-loc%3AADULT&sort_by=relevance&limit-yr=2020-&do=Search">Travel Guides</a>: Find inspiration for your next vacation.</li>

        <li><a href="/cgi-bin/koha/opac-shelves.pl?op=view&shelfnumber=7525">NOLO Guides</a>: Do it yourself legal guides, from Leavenworth Public Library.</li>

        <li><a href="/cgi-bin/koha/opac-shelves.pl?op=view&shelfnumber=9301">Celebrity Book Club List</a>: Book suggestions as shared by the prominent and famous</li>

        <li><a href="/cgi-bin/koha/opac-search.pl?advsearch=1&weight_search=on&do=Search&limit=mc-itype%2Cphr%3APBBKCLUB&sort_by=relevance">Book Club Sets</a>: Everything your book club needs to get started</li>

        <li><a href="/cgi-bin/koha/opac-shelves.pl?op=view&shelfnumber=8005">Open the Door to Literacy</a>: Books for the early developing mind.</li>

        <li><a href="/cgi-bin/koha/opac-shelves.pl?op=view&shelfnumber=9030">LGBTQ Pride</a>: Books that celebrate gay pride.</li>

      </ul>
    </p>


    <center>
      <h4>Movies</h4>
    </center>
    <p>
      <ul>
        <li><a href="/cgi-bin/koha/opac-search.pl?advsearch=1&idx=ti%2Cphr&q=street+date&weight_search=on&searchcat=N_VID&sort_by=acqdate_dsc&do=Search">Up Next</a>: Movies that will be available in the coming months, reserve your place in line.</li>

        <li><a href="/cgi-bin/koha/opac-search.pl?advsearch=1&idx=kw&q=a&op=not&idx=ti%2Cphr&q=street+date&weight_search=on&searchcat=N_VID&sort_by=acqdate_dsc&limit-yr=2021-&do=Search">New</a>: Movies that have recently been added to the Next: search catalog.</li>

        <li><a href="/cgi-bin/koha/opac-shelves.pl?op=view&shelfnumber=10871">Can’t Stream It – Borrow It</a>: Monthly list of movies in the catalog that are also new to paid streaming services (Netflix, Hulu, Amazon, etc.)</li>

      </ul>
    </p>

    <center>
      <h4>Music</h4>
    </center>
    <p>
      <ul>
        <li><a href="https://www.hoopladigital.com/browse/music/recommended?page=1">Hoopla Music</a>: Homepage for recommended music on the Hoopla service.</li>
      </ul>
    </p>

    <center>
      <h4>TV Series</h4>
    </center>
    <p>
      <ul>
        <li><a href="/cgi-bin/koha/opac-search.pl?advsearch=1&idx=kw&q=a&op=not&idx=ti%2Cphr&q=street+date&weight_search=on&do=Search&limit=mc-ccode%3AVID_B_T&limit=mc-ccode%3AVID_C_T&limit=mc-ccode%3AVID_D_T&limit=mc-ccode%3AVID_M_T&searchcat=N_VID&sort_by=acqdate_dsc&limit-yr=2021-">New</a>: Television series that have recently been added to the Next: search catalog.</li>
      </ul>
    </p>

    <center>
      <h4>Video Games</h4>
    </center>
    <p>
      <ul>
        <li><a href="/cgi-bin/koha/opac-shelves.pl?op=view&shelfnumber=7541">Library Journal's Best</a>: Video games that the Library Journal has named best of all time.</li>
      </ul>
    </p>
  </div>
</div>
</body>

























