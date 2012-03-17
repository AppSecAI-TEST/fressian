// Copyright (c) Metadata Partners, LLC.
// All rights reserved.

package org.fressian;

import java.io.IOException;
import java.nio.ByteBuffer;

public interface StreamingWriter {
    /**
     * Begin a variable-length closed list. This allows you (the writer)
     * to write very large things, or things of unknown size, without
     * having to place them in a collection first. However, you must
     * remember to call endList when you are done, or the resulting
     * stream will not be readable.
     * @return this Writer (fluent)
     * @throws IOException
     */
    public Writer beginClosedList() throws IOException;

    /**
     * Mark the end of a variable-lenght list, either closed or open.
     * @return this Writer (fluent)
     * @throws IOException
     */
    public Writer endList() throws IOException;

    /**
     * Begin a variable-length open list. An open list can be terminated
     * either by a call to endList, *or* by an end of stream.  Using an
     * open is much more subtle than either a fixed or closed variable
     * list. Avoid it if either other choice can work.
     * @return this Writer (fluent)
     * @throws IOException
     */
    public Writer beginOpenList() throws IOException;

    /**
     * Write a footer for some existing fressianed data (the readable
     * portion of bb.) For advanced use when building a larger fressianed
     * stream from existing content.
     * @param bb
     * @throws IOException
     */
    public void writeFooterFor(ByteBuffer bb) throws IOException;
}
